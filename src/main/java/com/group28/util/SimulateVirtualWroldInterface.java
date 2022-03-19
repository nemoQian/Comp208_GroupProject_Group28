package com.group28.util;

import com.group28.pojo.Facility;
import com.group28.pojo.FacilityData;

public interface SimulateVirtualWroldInterface {

    void worldSimulateOpen ();

    void worldSimulateStop ();

    int addNewFacility (FacilityData facilityData, int[] location);

    long getTotalProduction ();

    long getTotalConsumption ();

    long getMaxConsumption();

    long getFacilityConsumption (Facility facility);

    int getTotalLose ();

    int getNumOfFacility ();

    int getNumOfPowerStation ();

    int getNumOfElectricityUnit ();

    String getFrontReferenceId (Facility facility);

}
