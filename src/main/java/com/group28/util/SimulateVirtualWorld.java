package com.group28.util;

import com.group28.pojo.Facility;
import com.group28.pojo.FacilityData;
import com.group28.pojo.PowerStation;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The type Simulate virtual world.
 *
 * @author Yihan Qian
 * @version 1.0
 */
public class SimulateVirtualWorld implements SimulateVirtualWroldInterface{

    /**
     * The Simulate time.
     */
    static SimulateTime simulateTime = new SimulateTime();
    /**
     * The Simulate map.
     */
    static SimulateMap simulateMap = new SimulateMap(10,16);

    private long totalProduction;
    private long totalConsumption;
    private long currentConsumption;
    private long totalLose;
    private long maxConsumption;

    private LinkedList<FacilityData> powerStationList;
    private LinkedList<FacilityData> electricityUnitList;
    private LinkedList<FacilityData> waitingAddList;
    private LinkedList<int[]> locationList;

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
        waitingAddList = new LinkedList<FacilityData>();
        locationList = new LinkedList<int[]>();

        totalProduction = 0L;
        totalConsumption = 0L;
        totalLose = 0L;

    }

    @Override
    public void worldSimulateOpen() {
        fixeedThreadPool.execute(() -> {worldSimulation();});
        fixeedThreadPool.execute(() -> {simulateTime.simulationOpen();});
    }

    @Override
    public void worldSimulateStop() {
        flag = false;

        simulateTime.simulationStop();
        fixeedThreadPool.shutdown();
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
            waitingAddList.add(facilityData);
            locationList.add(location);
            return 1;
        }
        else { return -1; }
    }

    @Override
    public long getTotalProduction() {
        return totalProduction;
    }

    @Override
    public long getTotalConsumption() {
        return totalConsumption;
    }

    @Override
    public long getMaxConsumption(){
        return maxConsumption + getTotalLose();
    }

    @Override
    public long getFacilityConsumption(Facility facility) {
        return 0;
    }

    @Override
    public int getTotalLose() {
        return 10 * simulateMap.getWorstTotalDistance();
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


    /**
     * World simulation.
     */
    public void worldSimulation() {
        System.out.println("World simulation open!");
        int timeNow = 0;
        while(flag){
            if(timeNow == 0 && waitingAddList.size() != 0){
                System.out.println(waitingAddList.size());
                for (int i = 0; i<waitingAddList.size(); i++){
                    if(waitingAddList.get(i).getFacility() instanceof PowerStation){
                        powerStationList.add(waitingAddList.get(i));
                    }
                    else {
                        electricityUnitList.add(waitingAddList.get(i));
                        maxConsumption += waitingAddList.get(i).getMaximum();
                    }
                    simulateMap.addNewFacility(waitingAddList.get(i).getFacility(), locationList.get(i));
                }
                waitingAddList.clear();
            }
            if(simulateTime.getHour() - timeNow >= 1){
                timeNow = simulateTime.getHour();
                currentConsumption = 0;
                for (int i = 0; i<electricityUnitList.size(); i++){
                    currentConsumption += electricityUnitList.get(i).getConsumption();
                }
                totalConsumption += currentConsumption;
                totalProduction = currentConsumption + getTotalLose();
                System.out.println("currentConsumption " + currentConsumption);
                System.out.println("totalProduction " + totalProduction);
            }
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
