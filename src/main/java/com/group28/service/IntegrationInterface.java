package com.group28.service;

public interface IntegrationInterface {

    int[] worldSimulationOpen () throws InterruptedException;

    int worldSimulationReset ();

    int addNewFacility (String facilityType, String facilityName, int locationX, int locationY, String facilityLevel);

    int getTotalConsumption ();

    int getTotalProduction ();

    int getElectricityUnitConsumption  (String electricityUnitName);

    int getPowerStationProduction  (String powerStationName);

    int getTypicalTypeConsumption (String electricityUnitType);

    int getRateOfTypicalType (String electricityUnitType);
}
