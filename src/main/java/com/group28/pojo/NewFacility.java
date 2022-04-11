//package com.group28.pojo;
//
//import com.group28.dao.FacilityDao;
//import com.group28.dao.PowerStationDao;
//import com.group28.dao.ZipCodeDao;
//import com.group28.util.MyBatisUtil;
//import org.apache.ibatis.session.SqlSession;
//
//import java.util.List;
///**
// *
// * @author Yuyuan Cao
// * @version 1.1
// */
//public class NewFacility {
//    public ZipCode searchFacility(String zipCode){
//        SqlSession sqlSession = MyBatisUtil.getSqlSession();
//        ZipCodeDao mapper = sqlSession.getMapper(ZipCodeDao.class);
//        ZipCode facilityZip = mapper.getZipCode(zipCode);
//        sqlSession.close();
//        return facilityZip;
//    }
//
//    public List<ZipCode> GetZipCodeList() {
//        SqlSession sqlSession = MyBatisUtil.getSqlSession();
//        ZipCodeDao mapper = sqlSession.getMapper(ZipCodeDao.class);
//
//        List<ZipCode> ZipCodeList = mapper.getZipCodeList();
//
//        sqlSession.close();
//        return  ZipCodeList;
//    }
//
//    public void FacilityAdd(String facilityId,ZipCode zipCode, FacilityType facilityType, String facilityName){
//
//        if(facilityType.getType_Id().length()==3){
//            SqlSession sqlSession = MyBatisUtil.getSqlSession();
//            FacilityDao mapper = sqlSession.getMapper(FacilityDao.class);
//            ElectricityUnitType electricityUnitType = new ElectricityUnitType(facilityType.getType_Id(), facilityType.getMAX_NUMERICAL(),facilityType.getMIN_NUMERICAL());
//            ElectricityUnit newEle = new ElectricityUnit(zipCode, electricityUnitType, facilityId,facilityName);
//            mapper.AddFacility(newEle);
//            sqlSession.commit();
//            System.out.println("Data inserted");
//            System.out.println("New Facility:" + newEle);
//        }else{
//            SqlSession sqlSession2 = MyBatisUtil.getSqlSession();
//            PowerStationDao mapper2 = sqlSession2.getMapper(PowerStationDao.class);
//
//            PowerStationType powerStationType = new PowerStationType(facilityType.getType_Id(), facilityType.getMAX_NUMERICAL());
//            PowerStation newPow = new PowerStation(zipCode, powerStationType, facilityId,facilityName);
//
//            mapper2.AddStation(newPow);
//            sqlSession2.commit();
//            System.out.println("Data inserted");
//            System.out.println("New Facility:" + newPow);
//        }
//
//    }
//
//
//}
