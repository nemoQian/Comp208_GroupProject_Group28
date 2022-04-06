package com.group28.dao;

import com.group28.pojo.ElectricityUnit;
import com.group28.pojo.ElectricityUnitType;
import com.group28.pojo.ElectricityUnitData;

import java.util.List;

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
     *
     * @return FacilityList
     */
    List<String> GetTypeIdList();

    List<String> GetUnitIdList();


    /**
     * Gets user.
     *
     * @param NewData
     * @return Specific Facility
     */
    void InsertData(ElectricityUnitData NewData);

    String GetTypeId(String electricityUnitId);

    int GetMaxConsumption(String type_Id);

    int GetMinConsumption(String type_Id);
}
