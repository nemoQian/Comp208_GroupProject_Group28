package com.group28.util;

import com.group28.pojo.Facility;

import java.util.ArrayList;
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
    private int numOfFacility;

    private final int ROW = 0;
    private final int COL = 1;
    private final int[] FAIL = new int[]{-1,-1};

    private int worstDistance = 0;
    private int bestDistance = 0;

    private int[][] matrix;
    private LinkedList<int[]> connection;
    private ArrayList<Integer> connectionLocation;
    private static final int INF = Integer.MAX_VALUE;

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
            facilitiesList.add(facility);
        }
        else { return -1; }

        if(facilitiesList.size() < 1){

        }
        else {
            for (int i = 0; i<facilitiesList.size(); i++){
                worstDistance += getDistance(facility, facilitiesList.get(i));
            }
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

    public int getBestDistance() { return bestDistance; }

    private void generateMatrix(){
        numOfFacility = facilitiesList.size();
        matrix = new int[numOfFacility][numOfFacility];
        for(int i = 0; i<numOfFacility; i++){
            for(int j = 0; j<numOfFacility; j++){
                if(i == j){
                    matrix[i][j] = 0;
                }
                else {
                    matrix[i][j] = getDistance(facilitiesList.get(i), facilitiesList.get(j));
                }
            }
        }
    }

    private int getPosition(Facility facility){
        for(int i = 0; i<numOfFacility; i++){
            if(facilitiesList.get(i) == facility){
                return i;
            }
        }
        return -1;
    }

    public int[] prim(int start){
        generateMatrix();
        int index = 0;
        numOfFacility = facilitiesList.size();
        Facility[] prims = new Facility[numOfFacility];
        int[] weights = new int[numOfFacility];

        prims[index++] = facilitiesList.get(start);

        for(int i = 0; i<numOfFacility; i++){
            weights[i] = matrix[start][i];
        }
        weights[start] = 0;

        for(int i = 0; i<numOfFacility; i++){
            if(start == i){
                continue;
            }
            int j = 0;
            int k = 0;
            int min = INF;

            while(j < numOfFacility){
                if(weights[j] != 0 && weights[j] < min){
                    min = weights[j];
                    k = j;
                }
                j++;
            }

            prims[index++] = facilitiesList.get(k);
            weights[k] = 0;

            for(j = 0; j < numOfFacility; j++){
                if(weights[j] != 0 && matrix[k][j] < weights[j]){
                    weights[j] = matrix[k][j];
                }
            }
        }

        connection = new LinkedList<>();
        connectionLocation = new ArrayList<>();
        for(int i = 1; i < index; i++){
            int min = INF;
            int n = getPosition(prims[i]);

            for(int j = 0; j < i; j++){
                int m = getPosition(prims[j]);
                if(matrix[m][n] < min){
                    min = matrix[m][n];
                    connection.add(new int[]{m,n});
                }
            }
            bestDistance += min;
        }

        for(int i = 0; i<connection.size(); i++){
            Facility f1 = prims[connection.get(i)[0]];
            Facility f2 = prims[connection.get(i)[1]];
            connectionLocation.add(getFacilityLocation(f1)[0]);
            connectionLocation.add(getFacilityLocation(f1)[1]);
            connectionLocation.add(getFacilityLocation(f2)[0]);
            connectionLocation.add(getFacilityLocation(f2)[1]);
        }

        int[] locationArray = new int[connectionLocation.size()];
        for(int i = 0; i<connectionLocation.size(); i++){
            locationArray[i] = connectionLocation.get(i);
        }
        return locationArray;
    }
}
