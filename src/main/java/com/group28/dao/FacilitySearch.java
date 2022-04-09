package com.group28.dao;

import com.group28.pojo.ElectricityUnit;
import com.group28.pojo.ElectricityUnitType;
import com.group28.pojo.PowerStationType;
import com.group28.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class FacilitySearch {
    public void AddType(String type_Id, int MAX_CONSUMMPTION, int MIN_CONSUMMPTION){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();
        FacilityDao mapper = sqlsession.getMapper(FacilityDao.class);

        List<String> TypeList = mapper.GetTypeIdList();

        ElectricityUnitType NewType = new ElectricityUnitType();

        NewType.PutTypeId(type_Id);

        NewType.PutMAX_CONSUMMPTION(MAX_CONSUMMPTION);

        NewType.PutMIN_CONSUMMPTION(MIN_CONSUMMPTION);

        if(!(TypeList.contains(type_Id))){
            mapper.AddType(NewType);
            sqlsession.commit();
            System.out.println("New Type is:" + NewType);
        }
        else {
            System.out.println("Add Fail, break the primary key.");
        }
        sqlsession.close();
    }

    public void AddUnit(String electricityUnitId, String zipCode, String electricityUnitType, String electricityUnitName){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();
        FacilityDao mapper = sqlsession.getMapper(FacilityDao.class);
        ZipCodeDao ZipMapper = sqlsession.getMapper(ZipCodeDao.class);

        List<String> ZipCodeList = ZipMapper.getZipCode_CodeList();
        List<String> TypeList = mapper.GetTypeIdList();
        List<String> UnitList = mapper.GetUnitIdList();

        if (ZipCodeList.contains(zipCode) && TypeList.contains(electricityUnitType) && !(UnitList.contains(electricityUnitId))){
            ElectricityUnit NewUnit = new ElectricityUnit();

            NewUnit.Put_electricityUnitName(electricityUnitName);
            NewUnit.Put_electricityUnitId(electricityUnitId);
            NewUnit.Put_electricityUnitType(electricityUnitType);
            NewUnit.Put_zipCode(zipCode);

            mapper.AddFacility(NewUnit);
            sqlsession.commit();
            System.out.println("New Unit is" + NewUnit);
        }
        else {
            System.out.println("Add fail, break the foreign key rule or primary key rule");
        }

        sqlsession.close();
    }

    public void AddStationType(String type_Id, int MAX_PRODUCTION){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();
        PowerStationDao mapper = sqlsession.getMapper(PowerStationDao.class);

        List<String> TypeList = mapper.GetStationType_List();

        if (!(TypeList.contains(type_Id))){
            PowerStationType NewType = new PowerStationType();
            NewType.Put_type_Id(type_Id);
            NewType.Put_MAX_PRODUCTION(MAX_PRODUCTION);

            mapper.AddStationType(NewType);
            sqlsession.commit();
        }
        else {
            System.out.println("Type already existed");
        }


        sqlsession.close();
        System.out.println("Add Finish");
    }


    
}
