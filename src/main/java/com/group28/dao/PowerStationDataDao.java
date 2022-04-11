package com.group28.dao;

import com.group28.pojo.PowerStationData;

public interface PowerStationDataDao {
    int getAccumulatedProductivityAmount(String Time);

    void insertData(PowerStationData powerStationData);

    void deletePowerStation(String powerStationId);
}
