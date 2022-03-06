package com.group28.util;

import com.group28.pojo.Facility;

import java.util.LinkedList;

public class SimulateVirtualWorld implements Runnable, SimulateVirtualWroldInterface{

    static SimulateTime simulateTime = new SimulateTime();
    static SimulateMap simulateMap = new SimulateMap(16,10);

    private long totalProduction = 0;
    private long totalConsumpion = 0;
    private long totalLose = 0;

    private int numOfFacility;
    private int numOfPowerStation;
    private int numOfElectricityUnit;

    private LinkedList<Facility> powerStationList;
    private LinkedList<Facility> electricityUnitList;

    private static boolean flag = true;

    public SimulateVirtualWorld() {
        powerStationList = new LinkedList<Facility>();
        electricityUnitList = new LinkedList<Facility>();
    }

    @Override
    public void worldSimulateOpen() {

    }

    @Override
    public void worldSimulateStop() {

    }

    @Override
    public int addNewFacility(Facility facility) {
        /*
         * -1 means fail
         * 1 means successful
         * */
        int[] findExist = simulateMap.getFacilityLocation(facility);
        if(findExist[0] != -1 && findExist[1] != -1){
            final int dayNow = simulateTime.getDay();
        }
        else { return -1; }

        return 0;
    }

    @Override
    public long getTotalProduction(Facility facility) {
        return 0;
    }

    @Override
    public long getTotalConsumption(Facility facility) {
        return 0;
    }

    @Override
    public long getFacilityProduction(Facility facility) {
        return 0;
    }

    @Override
    public long getFacilityConsumption(Facility facility) {
        return 0;
    }

    @Override
    public int getTotalLose() {
        return 0;
    }

    @Override
    public int getNumOfFacility() {
        return 0;
    }

    @Override
    public int getNumOfPowerStation() {
        return 0;
    }

    @Override
    public int getNumOfElectricityUnit() {
        return 0;
    }

    @Override
    public String getFrontReferenceId(Facility facility) {
        return null;
    }

    @Override
    public void run() {
        simulateTime.simulationOpen();
    }
}
