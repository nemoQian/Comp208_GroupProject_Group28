package com.group28.dao;

import com.group28.pojo.ElectricityUnit;
import com.group28.pojo.ElectricityUnitType;
import com.group28.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ElectricityDaoTest {
    @Test
    public void SearchTypeListTest(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();
        FacilityDao mapper = sqlsession.getMapper(FacilityDao.class);

        List<String> unit1 = mapper.GetTypeIdList();
        System.out.println(unit1);

        sqlsession.close();
    }

    @Test
    public void SearchUnitListTest(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();
        FacilityDao mapper = sqlsession.getMapper(FacilityDao.class);

        List<String> unit1 = mapper.GetUnitIdList();
        System.out.println(unit1);

        sqlsession.close();
    }

    @Test
    public void SearchTypeIDTest(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();
        FacilityDao mapper = sqlsession.getMapper(FacilityDao.class);

        String TypeID = mapper.GetTypeId("SP1S1A02");

        System.out.println(TypeID);
    }

    @Test
    public void SearchMaxCon(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();
        FacilityDao mapper = sqlsession.getMapper(FacilityDao.class);

        int MaxConsumption = mapper.GetMaxConsumption("SP1");

        System.out.println(MaxConsumption);
    }

    @Test
    public void SearchMinCon(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();
        FacilityDao mapper = sqlsession.getMapper(FacilityDao.class);

        int MaxConsumption = mapper.GetMinConsumption("SP1");

        System.out.println(MaxConsumption);
    }
}
