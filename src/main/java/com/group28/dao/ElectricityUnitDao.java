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

public interface ElectricityUnitDao {

    String findElectricityUnit (String electricityUnitName);
    ElectricityUnitType findElectricityUnitType(String electricityUnitType);

    void AddType(ElectricityUnitType NewType);

    void AddFacility(ElectricityUnit Newunit);

    List<String> GetTypeIdList();

    List<String> GetUnitIdList();

    void InsertData(ElectricityUnitData NewData);

    String GetTypeId(String electricityUnitId);

    int GetMaxConsumption(String type_Id);

    int GetMinConsumption(String type_Id);

    void DeleteElectricityUnit(String electricityUnitId);

    void DeleteElectricityType(String type_Id);

}
