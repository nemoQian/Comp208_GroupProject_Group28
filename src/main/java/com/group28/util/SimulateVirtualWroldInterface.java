package com.group28.util;

import com.group28.pojo.Facility;

public interface SimulateVirtualWroldInterface {

    void worldSimulateOpen ();

    void worldSimulateStop ();

    int addNewFacility (Facility facility);

    long getTotalProduction (Facility facility);

    long getTotalConsumption (Facility facility);

    long getFacilityProduction (Facility facility);

    long getFacilityConsumption (Facility facility);

    int getTotalLose ();

    int getNumOfFacility ();

    int getNumOfPowerStation ();

    int getNumOfElectricityUnit ();

    String getFrontReferenceId (Facility facility);

}
