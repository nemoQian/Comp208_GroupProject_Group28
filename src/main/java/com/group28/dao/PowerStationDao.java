package com.group28.dao;

import com.group28.pojo.PowerStation;
import com.group28.pojo.PowerStationType;

import java.util.List;

public interface PowerStationDao {
    void AddStationType(PowerStationType NewType);
    void AddStation(PowerStation NewStation);
    List<String> GetStationType_List(String type_Id);
    List<String> GetStationList(String powerStationId);
}
