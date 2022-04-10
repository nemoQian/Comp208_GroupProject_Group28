package com.group28.dao;

import com.group28.pojo.PowerStation;
import com.group28.pojo.PowerStationType;

import java.util.List;

public interface PowerStationDao {
    String findPowerStation (String powerStationName);
    PowerStationType findPowerStationType(String powerStationType);
    void AddStationType(PowerStationType NewType);
    void AddStation(PowerStation NewStation);
    List<String> GetStationType_List();
    List<String> GetStationList();
    void DeleteStation(String powerStationId);
    void DeleteStationType(String type_Id);
    String GetType(String powerStationId);
    int GetProduction(String type_Id);
}
