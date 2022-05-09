package com.group28.util;

import com.group28.pojo.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The type Simulate map.
 *
 * @author Yihan Qian, Yuyuan Cao
 * @version 1.1
 */
public class SimulateMap implements SimulateMapInterface {

    /* facilitiesMap stores the location of each facility */
    private LinkedList<int[]> facilitiesMap;
    /* use concurrent hash map to store the mapping between facility and location and make thread safety */
    private ConcurrentHashMap<Facility, int[]> facilityLocationMap;
    /* facilitiesList helps to find the facility by index */
    private LinkedList<Facility> facilitiesList;
    /* count the number of the facilities */
    private int numOfFacility;

    /* store the electricity unit */
    private LinkedList<Facility> electricityUnitLinkedList;
    /* store the power station */
    private LinkedList<Facility> powerStationLinkedList;

    /* used to generate the connection */
    private LinkedList<LinkedList<Facility>> connectionList;

    /* the row of the location is the first element of the array */
    private final int ROW = 0;
    /* the col of the location is the second element of the array */
    private final int COL = 1;
    /* if fail return this array */
    private final int[] FAIL = new int[]{-1,-1};

    private int worstDistance = 0;
    private int bestDistance = 0;

    private int[][] matrix;
    private ArrayList<Integer> connectionLocation;
    private static final int INF = Integer.MAX_VALUE;

    /**
     * Instantiates a new Simulate map.
     *
     */
    public SimulateMap(){

        /* initial each list and map first */
        facilitiesMap = new LinkedList<int[]>();
        facilityLocationMap = new ConcurrentHashMap<Facility, int[]>();
        facilitiesList = new LinkedList<Facility>();

        electricityUnitLinkedList = new LinkedList<Facility>();
        powerStationLinkedList = new LinkedList<Facility>();

        System.out.println("Map created!");

    }

    public void resetMap(){
        /* reset the map is to clean each list */
        facilitiesMap.clear();
        facilityLocationMap.clear();
        facilitiesList.clear();
        electricityUnitLinkedList.clear();
        powerStationLinkedList.clear();
    }

    @Override
    public int addNewFacility(Facility facility, int[] location) {
        /*
        * -1 means fail
        * 1 means successful
        * */

        /* if the location is invalid return fail */
        if(location[ROW] < 0 || location[COL] < 0) { return -1; }

        /* if the location does not exist before, add it */
        if(!facilityLocationMap.containsValue(location) && !facilityLocationMap.containsKey(facility)){
            facilitiesMap.add(location);
            facilityLocationMap.put(facility,location);
            facilitiesList.add(facility);
            if(facility instanceof PowerStation){
                powerStationLinkedList.add(facility);
            }
            else { electricityUnitLinkedList.add(facility); }
        }
        else { return -1; }

        /* count the worst distance if there exists more than 2 facilities */
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

    public int getWorstTotalDistance(){  return worstDistance; }

    public int getBestDistance() { return bestDistance; }

    private int getPosition(Facility facility){
        /* it will return the index of the facility in the facilitiesList */
        for(int i = 0; i<numOfFacility; i++){
            if(facilitiesList.get(i) == facility){
                return i;
            }
        }
        return -1;
    }

    private void generateMatrix(LinkedList<Facility> fl){
        /* it will generate the adjacency matrix to be used in prim algorithm */
        numOfFacility = fl.size();
        /* declare a new array according to the input list size */
        matrix = new int[numOfFacility][numOfFacility];
        /* store the distance in the matrix */
        for(int i = 0; i<numOfFacility; i++){
            for(int j = 0; j<numOfFacility; j++){
                if(i == j){
                    matrix[i][j] = 0;
                }
                else {
                    matrix[i][j] = getDistance(fl.get(i), fl.get(j));
                }
            }
        }
    }

    public void prim(LinkedList<Facility> fl){
        /* use prim algorithm to generate MST */
        if(fl.size() <= 1){
            System.out.println("hhhh");
            return;
        }
        generateMatrix(fl);
        Graph<String> graph = new Graph<String>();
        graph.setVertexNum(fl.size());
        graph.setArcNum(fl.size()*fl.size());
        graph.setArc(matrix);
        String[] vertex = new String[fl.size()];
        for (int i = 0;i < vertex.length ; i++) {
            vertex[i] = "vertex"+i;
        }
        graph.setVertex(vertex);
        Prim<String> prim =new Prim<String>();
        prim.setGraph(graph);
        Map<Integer,ShortEdge> resultMap = prim.prim();
        for(int key:resultMap.keySet()) {
            System.out.format("Edge%d"+"-"+"%d,"+"Value：%d\n",key,resultMap.get(key).getAdjvex(),
                    resultMap.get(key).getLowCost());
            bestDistance += resultMap.get(key).getLowCost();
            connectionLocation.add(getFacilityLocation(fl.get(key))[0]);
            connectionLocation.add(getFacilityLocation(fl.get(key))[1]);
            connectionLocation.add(getFacilityLocation(fl.get(resultMap.get(key).getAdjvex()))[0]);
            connectionLocation.add(getFacilityLocation(fl.get(resultMap.get(key).getAdjvex()))[1]);
        }

    }

    private void generateClosestList(){
        /* use k-means algorithm to cluster each electricity unit to the power station */
        connectionList = new LinkedList<LinkedList<Facility>>();

        for(int i = 0; i<powerStationLinkedList.size(); i++){
            LinkedList<Facility> cl = new LinkedList<Facility>();
            cl.add(powerStationLinkedList.get(i));
            connectionList.add(cl);
        }
        for(int i = 0; i<electricityUnitLinkedList.size(); i++){
            int min = INF;
            int index = 0;
            for(int j = 0; j<powerStationLinkedList.size(); j++){
                int dis = getDistance(electricityUnitLinkedList.get(i),powerStationLinkedList.get(j));
                if(dis < min){
                    min = dis;
                    index = j;
                }
            }
            connectionList.get(index).add(electricityUnitLinkedList.get(i));
        }
    }

    public int[] generatePrimArray(){
        /* it will generate the connection array after using prim algorithm*/
        connectionLocation = new ArrayList<Integer>();
        if(powerStationLinkedList.size() == 1){
            prim(facilitiesList);
        }
        else {
            generateClosestList();
            for (int i = 0; i<connectionList.size();i++){
                prim(connectionList.get(i));
            }
        }

        int[] locationArray = new int[connectionLocation.size()];
        for(int i = 0; i<connectionLocation.size(); i++){
            locationArray[i] = connectionLocation.get(i);
        }
        System.out.println(bestDistance);
        return locationArray;
    }

}
