package com.group28.util;

import com.group28.pojo.*;
import org.junit.Test;

import java.util.Arrays;

/**
 * The type Test simulate map.
 *
 * @author Yihan Qian
 * @version 1.1
 */
public class TestSimulateMap {

    private static SimulateMap map = new SimulateMap();

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

        zipCode = new ZipCode("S1 A03", "Richelieu Apartment");
        ElectricityUnitType electricityUnitType = new ElectricityUnitType("PB1", 150L, 60L);
        Facility electricityUnit = new ElectricityUnit(zipCode, electricityUnitType,
                "PB1S1A01", "Champs Elysees Shopping mall");

        int a[] = new int[]{2,3};

        System.out.println(map.addNewFacility(powerStation, new int[]{-1, 3})); // -1
        System.out.println(map.addNewFacility(powerStation, a)); // 1
        System.out.println(map.addNewFacility(powerStation1, a)); // -1
        System.out.println(map.addNewFacility(powerStation, a)); // -1
        System.out.println(map.addNewFacility(powerStation, new int[]{3,5})); // -1
        System.out.println(Arrays.toString(map.getFacilityLocation(powerStation1))); // [-1,-1]
        System.out.println(map.addNewFacility(powerStation1, new int[]{4,1})); // 1
        System.out.println(map.addNewFacility(electricityUnit, new int[]{2,2})); // 1

        System.out.println(Arrays.toString(map.getFacilityLocation(powerStation))); // [2,3]
        System.out.println(Arrays.toString(map.getFacilityLocation(powerStation1))); // [4,1]
        System.out.println(Arrays.toString(map.getFacilityLocation(electricityUnit))); // [2,2]

        System.out.println(map.getDistance(powerStation,powerStation1)); // 4
        System.out.println(map.getDistance(electricityUnit,powerStation1)); // 3
        System.out.println(map.getDistance(electricityUnit,powerStation)); // 1

        System.out.println(map.getWorstTotalDistance()); // 8

    }
}
