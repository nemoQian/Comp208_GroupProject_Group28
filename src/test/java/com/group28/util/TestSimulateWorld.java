package com.group28.util;

import com.group28.pojo.*;

import java.util.Scanner;

public class TestSimulateWorld {

    static SimulateVirtualWorld simulateVirtualWorld = new SimulateVirtualWorld();

    public static void main(String[] args) {

        ZipCode zipCode = new ZipCode("S1 A01", "Champs Elysees St");
        PowerStationType powerStationType = new PowerStationType("FI", 600L);
        Facility powerStation = new PowerStation(zipCode, powerStationType,
                "FI1S3X01", "Napoleon Power Station");
        FacilityData facilityData1 = new FacilityData(powerStation, powerStationType);

        zipCode = new ZipCode("S2 Y01", "Asgard Station");
        powerStationType = new PowerStationType("FI", 600L);
        Facility powerStation1 = new PowerStation(zipCode, powerStationType,
                "FI1S2Y01", "Asgard Power Station");
        FacilityData facilityData2 = new FacilityData(powerStation1, powerStationType);

        zipCode = new ZipCode("S1 A03", "Richelieu Apartment");
        ElectricityUnitType electricityUnitType = new ElectricityUnitType("PB1", 150L, 60L);
        Facility electricityUnit = new ElectricityUnit(zipCode, electricityUnitType,
                                            "PB1S1A01", "Champs Elysees Shopping mall");
        FacilityData facilityData3 = new FacilityData(electricityUnit, electricityUnitType);



        boolean s = true;
        Scanner scanner = new Scanner(System.in);

        simulateVirtualWorld.worldSimulateOpen();

        while (s){
            int a = scanner.nextInt();
            if(a == 1){
                System.out.println(simulateVirtualWorld.getTotalConsumption());
            }
            else if(a == 2){
                System.out.println(simulateVirtualWorld.getTotalProduction());
            }
            else if(a == 3){
                System.out.println(simulateVirtualWorld.getNumOfElectricityUnit());
            }
            else if(a == 5){
                System.out.println(simulateVirtualWorld.getNumOfPowerStation());
            }
            else if(a == 4){
                s = false;
            }
            else if(a == 6){
                System.out.println(simulateVirtualWorld.addNewFacility(facilityData3, new int[]{2,3}));
            }
            else if(a == 7){
                System.out.println(simulateVirtualWorld.getTotalLose());
            }
        }

        simulateVirtualWorld.worldSimulateStop();
    }
}
