package com.group28.dao;

import com.group28.pojo.ElectricityUnit;
import com.group28.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class TestElectricityUnitDao {
    @Test
    public void searchElectricityUnitTest(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();
        ElectricityUnitDao mapper = sqlsession.getMapper(ElectricityUnitDao.class);
        List<ElectricityUnit> euList = mapper.getElectricityUnit();
        for (ElectricityUnit eu : euList) {
            System.out.println(eu);
        }
        sqlsession.close();
    }
}