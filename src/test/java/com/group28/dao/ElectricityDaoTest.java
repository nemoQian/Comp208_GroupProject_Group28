package com.group28.dao;

import com.group28.pojo.ElectricityUnit;
import com.group28.pojo.ElectricityUnitType;
import com.group28.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ElectricityDaoTest {
    @Test
    public void searchElectricityUnitByName(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();
        ElectricityUnitDao mapper = sqlsession.getMapper(ElectricityUnitDao.class);
        System.out.println(mapper.findElectricityUnit("Louvre Mseum"));
        sqlsession.close();
    }

    @Test
    public void searchPowerStationTypeByName(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();
        ElectricityUnitDao mapper = sqlsession.getMapper(ElectricityUnitDao.class);
        System.out.println(mapper.findElectricityUnitType("AP1"));
        sqlsession.close();
    }

    @Test
    public void SearchTypeListTest(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();
        ElectricityUnitDao mapper = sqlsession.getMapper(ElectricityUnitDao.class);

        List<String> unit1 = mapper.GetTypeIdList();
        System.out.println(unit1);

        sqlsession.close();
    }

    @Test
    public void SearchUnitListTest(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();
        ElectricityUnitDao mapper = sqlsession.getMapper(ElectricityUnitDao.class);

        List<String> unit1 = mapper.GetUnitIdList();
        System.out.println(unit1);

        sqlsession.close();
    }

    @Test
    public void SearchTypeIDTest(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();
        ElectricityUnitDao mapper = sqlsession.getMapper(ElectricityUnitDao.class);

        String TypeID = mapper.GetTypeId("AP1S1A03");

        System.out.println(TypeID);
    }

    @Test
    public void SearchMaxCon(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();
        ElectricityUnitDao mapper = sqlsession.getMapper(ElectricityUnitDao.class);

        int MaxConsumption = mapper.GetMaxConsumption("SP1");

        System.out.println(MaxConsumption);
    }

    @Test
    public void SearchMinCon(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();
        ElectricityUnitDao mapper = sqlsession.getMapper(ElectricityUnitDao.class);

        int Min = mapper.GetMinConsumption("SP1");

        System.out.println(Min);
    }
}
