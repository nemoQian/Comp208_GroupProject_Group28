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

    @Test
    public void insertDataTest(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();

        ElectricityUnitDataDao mapper = sqlsession.getMapper(ElectricityUnitDataDao.class);
        ElectricityUnitData electricityUnitData = new ElectricityUnitData();

        electricityUnitData.Put_DATA_REFERENCE_ID("E11");
        electricityUnitData.Put_electricityUnitId("AP1S1A03");
        electricityUnitData.Put_timeOfStore("2022-04-01-11");
        electricityUnitData.Put_ConsumptionAmount(300);

        mapper.insertData(electricityUnitData);


        sqlsession.commit();
        sqlsession.close();
    }

    @Test
    public void deleteElectricityUnitData(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();

        ElectricityUnitDataDao mapper = sqlsession.getMapper(ElectricityUnitDataDao.class);
        mapper.deleteElectricityUnitData("AP1S1A03");


        sqlsession.commit();
        sqlsession.close();
    }



}
