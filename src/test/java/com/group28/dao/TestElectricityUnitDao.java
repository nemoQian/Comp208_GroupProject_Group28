package com.group28.dao;

import com.group28.pojo.ElectricityUnit;
import com.group28.pojo.ElectricityUnitType;
import com.group28.pojo.ZipCode;
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

    @Test
    public void AddTypeTest(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();
        FacilityDao mapper = sqlsession.getMapper(FacilityDao.class);

        ElectricityUnitType NewType = new ElectricityUnitType();

        NewType.PutTypeId("PB9");

        NewType.PutMAX_CONSUMMPTION(200);

        NewType.PutMIN_CONSUMMPTION(100);

        mapper.AddType(NewType);

        sqlsession.commit();

        System.out.println(NewType);
    }

    @Test
    public void AddUnitTest(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();

        FacilityDao mapper = sqlsession.getMapper(FacilityDao.class);

        String ElectricityUnitID = "PB9S1A01";

        String PlaceName = "CYY's House";

        ElectricityUnit NewUnit = new ElectricityUnit();

        NewUnit.Put_electricityUnitId(ElectricityUnitID);
        NewUnit.Put_zipCode("S1 A01");
        NewUnit.Put_electricityUnitType("PB9");
        NewUnit.Put_electricityUnitName(PlaceName);

        mapper.AddFacility(NewUnit);

        sqlsession.commit();
        sqlsession.close();


    }


}