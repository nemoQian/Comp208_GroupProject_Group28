package com.group28.dao;

import com.group28.pojo.ElectricityUnitData;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface ElectricityUnitDataDao {


    int getAccumulatedConsumptionAmount(String Time);

    void insertData(ElectricityUnitData electricityUnitData);



//    int getConsumptionAmountByTimePerHour(String electricityUnit,String timeOfStore);
//
//    int getConsumptionAmountByTimePerDay(String electricityUnit,String day);
//
//    int getConsumptionAmountByTimePerMonth(String electricityUnit,String Month);
//
//    int getConsumptionAmountByTimePerYear(String electricityUnit,String year);

}
