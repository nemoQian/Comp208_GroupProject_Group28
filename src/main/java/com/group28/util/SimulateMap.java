package com.group28.util;

import com.group28.pojo.Facility;

import java.util.HashMap;

/**
 * The type Simulate map.
 *
 * @Yihan Qian
 * @version 1.0
 */
public class SimulateMap implements SimulateMapInterface {

    private int numOfRow;
    private int numOfCol;

    private Facility[][] map;
    private int[][] EnergyMatrix;
    private HashMap<Facility, int[]> facilityLocation;

    private final int ROW = 0;
    private final int COL = 0;
    private final int[] FAIL = new int[]{-1,-1};

    /**
     * Instantiates a new Simulate map.
     *
     * @param numOfRow the num of row
     * @param numOfCol the num of col
     */
    public SimulateMap(int numOfRow, int numOfCol){
        this.numOfRow = numOfRow;
        this.numOfCol = numOfCol;

        this.map = new Facility[numOfRow][numOfCol];
        this.EnergyMatrix = new int[numOfRow][numOfCol];

        this.facilityLocation = new HashMap<Facility, int[]>();

        for(int i = 0; i < numOfRow; i++){
            for (int j = 0; j < numOfCol; j++){
                EnergyMatrix[i][j] = -1;
            }
        }

    }

    @Override
    public int addNewFacility(Facility facility, int[] location) {
        /*
        * -1 means fail
        * 1 means successful
        * */
        if(location[ROW] < 0 || location[ROW] >= numOfRow
                || location[COL] < 0 || location[COL] >= numOfCol) { return -1; }

        if(!facilityLocation.containsValue(location)){
            map[location[ROW]][location[COL]] = facility;
            facilityLocation.put(facility,location);
            return 1;
        }
        else { return -1; }
    }

    @Override
    public int[] getFacilityLocation(Facility facility) {
        if (facilityLocation.containsKey(facility)) { return facilityLocation.get(facility); }
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

    @Override
    public int[][] getEnergyMatrix() {
        return EnergyMatrix;
    }
}