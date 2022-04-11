package com.group28.dao;

import com.group28.pojo.ElectricityUnitData;
import com.group28.pojo.PowerStationData;
import com.group28.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class PowerStationDataDaoTest {
    @Test
    public void getAccumulatedProductivityAmount(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();

        PowerStationDataDao mapper = sqlsession.getMapper(PowerStationDataDao.class);

        int productivity = mapper.getAccumulatedProductivityAmount("2022-01-01");
        System.out.println(productivity);

        sqlsession.close();
    }

    @Test
    public void insertData(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();

        PowerStationDataDao mapper = sqlsession.getMapper(PowerStationDataDao.class);

        PowerStationData powerStationData = new PowerStationData();

        powerStationData.Put_DATA_REFERENCE_ID("P14");
        powerStationData.Put_powerStationId("FI1S1Z01");
        powerStationData.Put_timeOfStore("2022-04-01-11");
        powerStationData.Put_productivityAmount(300);

        mapper.insertData(powerStationData);

        sqlsession.commit();
        sqlsession.close();
    }

    @Test
    public void deletePowerStation(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();

        PowerStationDataDao mapper = sqlsession.getMapper(PowerStationDataDao.class);

       mapper.deletePowerStation("FI1S1Z01");

        sqlsession.commit();
        sqlsession.close();
    }
}
