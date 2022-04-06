package com.group28.dao;

import com.group28.pojo.ElectricityUnit;
import com.group28.pojo.ElectricityUnitData;
import com.group28.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class ElectricityUnitDataDaoTest {

    @Test
    public void getAccumulatedConsumptionAmountTest(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();

        ElectricityUnitDataDao mapper = sqlsession.getMapper(ElectricityUnitDataDao.class);

        int Consumption = mapper.getAccumulatedConsumptionAmount("2022-01-01");
        System.out.println(Consumption);

        sqlsession.close();
    }

//    @Test
//    public void getConsumptionAmountByTimePerMonth(){
//        SqlSession sqlsession = MyBatisUtil.getSqlSession();
//
//        ElectricityUnitDataDao mapper = sqlsession.getMapper(ElectricityUnitDataDao.class);
//
//        int MonthConsumption = mapper.getConsumptionAmountByTimePerMonth();
//        System.out.println(MonthConsumption);
//
//        sqlsession.close();
//    }
//
//    @Test
//    public void getConsumptionAmountByTimePerYear(){
//        SqlSession sqlsession = MyBatisUtil.getSqlSession();
//
//        ElectricityUnitDataDao mapper = sqlsession.getMapper(ElectricityUnitDataDao.class);
//
//        int yearConsumption = mapper.getConsumptionAmountByTimePerYear();
//        System.out.println(yearConsumption);
//
//        sqlsession.close();
//    }
//
//    @Test
//    public void getConsumptionAmountByTimePerDay(){
//        SqlSession sqlsession = MyBatisUtil.getSqlSession();
//
//        ElectricityUnitDataDao mapper = sqlsession.getMapper(ElectricityUnitDataDao.class);
//
//        int dayConsumption = mapper.getConsumptionAmountByTimePerDay();
//        System.out.println(dayConsumption);
//
//        sqlsession.close();
//    }
}
