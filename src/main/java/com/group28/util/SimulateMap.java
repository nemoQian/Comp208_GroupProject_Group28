package com.group28.util;

import com.group28.pojo.Facility;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The type Simulate map.
 *
 * @Yihan Qian
 * @version 1.1
 */
public class SimulateMap implements SimulateMapInterface {

    private LinkedList<int[]> facilitiesMap;
    private ConcurrentHashMap<Facility, int[]> facilityLocationMap;
    private LinkedList<Facility> facilitiesList;

    private final int ROW = 0;
    private final int COL = 1;
    private final int[] FAIL = new int[]{-1,-1};

    private int worstDistance = 0;

    /**
     * Instantiates a new Simulate map.
     *
     */
    public SimulateMap(){

        this.facilitiesMap = new LinkedList<int[]>();
        this.facilityLocationMap = new ConcurrentHashMap<Facility, int[]>();
        this.facilitiesList = new LinkedList<Facility>();

        System.out.println("Map created!");

    }

    @Override
    public int addNewFacility(Facility facility, int[] location) {
        /*
        * -1 means fail
        * 1 means successful
        * */
        if(location[ROW] < 0 || location[COL] < 0) { return -1; }

        if(!facilityLocationMap.containsValue(location) && !facilityLocationMap.containsKey(facility)){
            facilitiesMap.add(location);
            facilityLocationMap.put(facility,location);
        }
        else { return -1; }

        if(facilitiesList.size() < 1){
            facilitiesList.add(facility);
        }
        else {
            for (int i = 0; i<facilitiesList.size(); i++){
                worstDistance += getDistance(facility, facilitiesList.get(i));
            }
            facilitiesList.add(facility);
        }

        return 1;
    }

    @Override
    public int[] getFacilityLocation(Facility facility) {
        if (facilityLocationMap.containsKey(facility)) { return facilityLocationMap.get(facility); }
        else { return FAIL; }
    }

    @Override
    public int getDistance(Facility facility1, Facility facility2) {
        int[] firstLocation = getFacilityLocation(facility1);
        int[] secondLocation = getFacilityLocation(facility2);

        if(firstLocation != FAIL && secondLocation != FAIL){
            int distance = Math.abs(firstLocation[ROW] - secondLocation[ROW]) +
                           Math.abs(firstLocation[COL] - secondLocation[COL]);
            return distance;
        }
        else { return -1; }
    }

    public int getWorstTotalDistance(){
        return worstDistance;
    }


}
