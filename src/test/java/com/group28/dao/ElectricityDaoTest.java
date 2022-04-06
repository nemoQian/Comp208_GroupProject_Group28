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
}
