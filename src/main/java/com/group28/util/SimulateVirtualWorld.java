package com.group28.util;

import com.group28.pojo.Facility;
import com.group28.pojo.FacilityData;
import com.group28.pojo.PowerStation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The type Simulate virtual world.

 * @author Yihan Qian, Lingfang li
 * @version 1.1
 */
public class SimulateVirtualWorld implements SimulateVirtualWorldInterface{

    /**
     * The Simulate time.
     */
    static SimulateTime simulateTime = new SimulateTime();
    /**
     * The Simulate map.
     */
    static SimulateMap simulateMap = new SimulateMap();

    private int totalProduction;
    private int totalConsumption;
    private int currentConsumption;
    private int currentProduction;
    private int totalLose;
    private int maxConsumption;
    private int maxProduction;
    private double rate;

    private LinkedList<FacilityData> powerStationList;
    private LinkedList<FacilityData> electricityUnitList;
    private LinkedList<int[]> locationList;
    private int[] fanChart;

    private ArrayList<ArrayList<Integer>> heightList;

    private static final String[] facilityTypeName = {"Community", "Hospital", "School", "PowerStation", "Shopping centre"};

    private static boolean flag = true;

    /**
     * The Fixeed thread pool.
     */
    ExecutorService fixeedThreadPool = Executors.newFixedThreadPool(5);

    private final int ROW = 0;
    private final int COL = 1;

    /**
     * Instantiates a new Simulate virtual world.
     */
    public SimulateVirtualWorld() {

        powerStationList = new LinkedList<FacilityData>();
        electricityUnitList = new LinkedList<FacilityData>();
        locationList = new LinkedList<int[]>();
        heightList = new ArrayList<>();

        totalProduction = 0;
        totalConsumption = 0;
        totalLose = 0;

        maxConsumption = 0;
        maxProduction = 0;
        rate = 1;

        fanChart = new int[5];
        for(int i = 0; i<5;i++){
            fanChart[i] = 0;
        }

    }

    @Override
    public void worldSimulateOpen() {
        flag = true;
        fixeedThreadPool.execute(() -> {worldSimulation();});
        fixeedThreadPool.execute(() -> {simulateTime.simulationOpen();});
    }

    @Override
    public void worldSimulateStop() {
        flag = false;

        simulateTime.simulationStop();
        System.out.println("World Simulation Stop!");
    }

    @Override
    public int addNewFacility(FacilityData facilityData, int[] location) {
        /*
         * -1 means fail
         * 1 means successful
         * */
        int[] findExist = simulateMap.getFacilityLocation(facilityData.getFacility());
        if(findExist[ROW] == -1 && findExist[COL] == -1){
            locationList.add(location);
            simulateMap.addNewFacility(facilityData.getFacility(),location);
            if(facilityData.getFacility() instanceof PowerStation){
                powerStationList.add(facilityData);
                maxProduction += facilityData.getMaximum();
            }
            else {
                electricityUnitList.add(facilityData);
                maxConsumption += facilityData.getMaximum();
            }
            return 1;
        }
        else { return -1; }
    }

    @Override
    public int getTotalProduction() { return totalProduction; }

    @Override
    public int getTotalConsumption() {
        return totalConsumption;
    }

    @Override
    public int getMaxConsumption(){
        return maxConsumption + getTotalLose();
    }

    @Override
    public int getFacilityConsumption(Facility facility) {
        return 0;
    }

    @Override
    public int getTotalLose() {
        return (int) (simulateMap.getBestDistance() * 0.5);
    }

    @Override
    public int getNumOfFacility() {
        return powerStationList.size() + electricityUnitList.size();
    }

    @Override
    public int getNumOfPowerStation() {
        return powerStationList.size();
    }

    @Override
    public int getNumOfElectricityUnit() {
        return electricityUnitList.size();
    }

    @Override
    public String getFrontReferenceId(Facility facility) { return null; }

    public int getCurrentConsumption(){ return currentConsumption; }

    public int getCurrentProduction(){ return currentProduction; }

    public String getTime(){ return simulateTime.getTimeNow(); }

    public ArrayList<ArrayList<Integer>> getHeightList(){
        return heightList;
    }

    public int[] getFanChart(){
        return fanChart;
    }

    public void generateHeightList(FacilityData facilityData, int consumption){
        ArrayList<Integer> heightData = new ArrayList<>();
        heightData = new ArrayList<>();
        int[] lo = simulateMap.getFacilityLocation(facilityData.getFacility());
        heightData.add(lo[0]);
        heightData.add(lo[1]);
        heightData.add(consumption);
        heightList.add(heightData);
    }

    public void generateFanChart(FacilityData facilityData, int consumption){
        if (facilityData.getFacilityName().equals(facilityTypeName[0])){
            fanChart[0] += consumption;
        }
        else if (facilityData.getFacilityName().equals(facilityTypeName[1])){
            fanChart[1] += consumption;
        }
        else if (facilityData.getFacilityName().equals(facilityTypeName[2])){
            fanChart[2] += consumption;
        }
        else if (facilityData.getFacilityName().equals(facilityTypeName[4])){
            fanChart[4] += consumption;
        }
    }

    private void update(){
        heightList.clear();
        rate = 1;
        //半夜生产量减少30%
        if(simulateTime.getHour()>=0 && simulateTime.getHour()<=7){
            rate = rate* 0.7;
        }
        //夏季增加30%
        if (simulateTime.getMonth() >= 6 && simulateTime.getMonth() <= 8) {
            rate = rate*1.3;
        }
        //冬季增加40%
        if ((simulateTime.getMonth()>=1 && simulateTime.getMonth()<=2) || simulateTime.getMonth()==12) {
            rate = rate*1.4;
        }
        fanChart = new int[5];
        for(int i = 0; i<5;i++){
            fanChart[i] = 0;
        }
        currentConsumption = 0;
        for (int i = 0; i<electricityUnitList.size(); i++){
            int consumption = (int) (electricityUnitList.get(i).getConsumption() * rate);
            currentConsumption += consumption;
            generateHeightList(electricityUnitList.get(i),consumption);
            generateFanChart(electricityUnitList.get(i),consumption);
        }
        totalConsumption += currentConsumption;
        currentProduction = currentConsumption + getTotalLose();
        fanChart[3] = currentProduction;
        totalProduction += currentProduction;
        System.out.println("currentConsumption " + currentConsumption);
        System.out.println("totalConsumption " + totalConsumption);
        System.out.println("totalProduction " + totalProduction);
    }

    /**
     * World simulation.
     */
    public void worldSimulation() {
        System.out.println("World simulation open!");
        int timeNow = 0;

        boolean zero = true;
        while(flag){
            if(simulateTime.getHour() - timeNow >= 1){
                update();
                timeNow = simulateTime.getHour();
                if (timeNow == 23){
                    zero = true;
                }
            }
            if(zero && simulateTime.getHour() == 0){
                update();
                zero = false;
                timeNow = simulateTime.getHour();
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean judgement(){
        if(maxConsumption + getTotalLose() > maxProduction){
            return false;
        }
        else { return true; }
    }

    public int[] prim(){
        return simulateMap.prim(0);
    }

    public void restWorld(){
        simulateTime = new SimulateTime();
        simulateMap.resetMap();
        powerStationList.clear();
        locationList.clear();
        electricityUnitList.clear();
    }
}
