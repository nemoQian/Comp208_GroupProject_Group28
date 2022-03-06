package com.group28.util;

import com.group28.pojo.*;
import org.junit.Test;

/**
 * The type Test simulate map.
 *
 * @author Yihan Qian
 * @version 1.1
 */
public class TestSimulateMap {

    private static SimulateMap map = new SimulateMap(10,10);

    /**
     * Test energy matrix.
     */
    @Test
    public void testEnergyMatrix(){
        int[][] energyMatrix = map.getEnergyMatrix();

        for (int[] row : energyMatrix){
            for (int col : row){
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    @Test
    public void testFacilityMap(){

        ZipCode zipCode = new ZipCode("S1 A01", "Champs Elysees St");
        PowerStationType powerStationType = new PowerStationType("FI", 600L);
        Facility powerStation = new PowerStation(zipCode, powerStationType,
                "FI1S3X01", "Napoleon Power Station");

        zipCode = new ZipCode("S2 Y01", "Asgard Station");
        powerStationType = new PowerStationType("FI", 600L);
        Facility powerStation1 = new PowerStation(zipCode, powerStationType,
                "FI1S2Y01", "Asgard Power Station");
        int a[] = new int[]{2,3};

        System.out.println(map.addNewFacility(powerStation, new int[]{11, 3}));
        System.out.println(map.addNewFacility(powerStation, a));
        System.out.println(map.addNewFacility(powerStation1, a));
        System.out.println(map.addNewFacility(powerStation, a));
        System.out.println(map.addNewFacility(powerStation1, new int[]{4,1}));

        System.out.println(map.getFacilityLocation(powerStation));
        System.out.println(map.getFacilityLocation(powerStation1));

        System.out.println(map.getDistance(powerStation,powerStation1));


    }
}
