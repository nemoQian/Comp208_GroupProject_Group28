package com.group28.dao;

import com.group28.pojo.PowerStation;
import com.group28.pojo.PowerStationType;
import com.group28.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class PowerStationDaoTest {
    @Test
    public void insertTypeTest(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        PowerStationDao mapper = sqlSession.getMapper(PowerStationDao.class);


        PowerStationType NewType = new PowerStationType();
        NewType.Put_type_Id("NP");
        NewType.Put_MAX_PRODUCTION(1500);

        mapper.AddStationType(NewType);

        sqlSession.commit();
        sqlSession.close();
        System.out.println("Finish");

    }

    @Test
    public void insertStationTest(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        PowerStationDao mapper = sqlSession.getMapper(PowerStationDao.class);

        PowerStation NewStation = new PowerStation();
        NewStation.Put_powerStationId("NU1S1Z01");
        NewStation.Put_zipCode("S1 Z01");
        NewStation.Put_powerStationType("NU");
        NewStation.Put_powerStationName("Chernobyl Station");

        mapper.AddStation(NewStation);
        sqlSession.commit();
        sqlSession.close();

        System.out.println("Finish");
    }

    @Test
    public void GetTypeListTest(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        PowerStationDao mapper = sqlSession.getMapper(PowerStationDao.class);

        List<String> TypeList = mapper.GetStationType_List();

        sqlSession.close();
        System.out.println(TypeList);
    }

    @Test
    public void GetStationListTest(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        PowerStationDao mapper = sqlSession.getMapper(PowerStationDao.class);

        List<String> StationList = mapper.GetStationList();

        sqlSession.close();
        System.out.println(StationList);
    }
}
