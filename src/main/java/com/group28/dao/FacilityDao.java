package com.group28.dao;

import com.group28.pojo.ElectricityUnit;
import com.group28.pojo.ElectricityUnitType;
import com.group28.pojo.ElectricityUnitData;

/**
 * The interface Electricity Facility.
 *
 * @author Yucheng Du
 * @version 1.0
 */

public interface FacilityDao {



    /**
     * Gets user.
     *
     * @param NewType
     * @return Specific Facility
     */
    void AddType(ElectricityUnitType NewType);

    /**
     * Gets user.
     *
     * @param Newunit
     * @return Added Facility
     */
    void AddFacility(ElectricityUnit Newunit);

    /**
     * Gets user.
     *
     * @param FacilityId
     * @return Specific Facility
     */
    ElectricityUnit SearchFacility(String FacilityId);


    /**
     * Gets user.
     *
     * @param ReferenceID, FacilityID, TimeOfStore, Consumption
     * @return Specific Facility
     */
    ElectricityUnitData InsertData(String ReferenceID, String FacilityID, String TimeOfStore, int Consumption);
}
