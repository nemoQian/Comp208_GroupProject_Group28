package com.group28.util;

import com.group28.pojo.Facility;
import com.group28.pojo.FacilityData;

public interface SimulateVirtualWorldInterface {

    void worldSimulateOpen ();

    void worldSimulateStop ();

    int addNewFacility (FacilityData facilityData, int[] location);

    int getTotalProduction ();

    int getTotalConsumption ();

    int getMaxConsumption();

    int getFacilityConsumption (Facility facility);

    int getTotalLose ();

    int getNumOfFacility ();

    int getNumOfPowerStation ();

    int getNumOfElectricityUnit ();

    String getFrontReferenceId (Facility facility);

}
