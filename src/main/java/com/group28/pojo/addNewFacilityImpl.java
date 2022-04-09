package com.group28.pojo;

import com.group28.dao.FacilityDao;
import com.group28.dao.UserDao;
import com.group28.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
/**
 *
 * @author Yuyuan Cao
 * @version 1.1
 */

public class addNewFacilityImpl implements addNewFacility{

    public String addFacility(String facilityId,String type_Id,String facilityName,String x,String y){
        NewFacility facility = new NewFacility();

        //location to zipcode
        String zipCode = "S" + x +" " + "A" + y;

        ZipCode fac = facility.searchFacility(zipCode);


        if(zipCode.equals(fac.getZipCode())){
            return "Not addable";

        }else{
            SqlSession sqlSession = MyBatisUtil.getSqlSession();
            FacilityDao mapper = sqlSession.getMapper(FacilityDao.class);
            int maxint = mapper.GetMaxConsumption(type_Id);
            FacilityDao mapper2 = sqlSession.getMapper(FacilityDao.class);
            int minint = mapper2.GetMinConsumption(type_Id);
            sqlSession.close();
            Long max = new Long(maxint);
            Long min = new Long(minint);
            FacilityType facilityType = new FacilityType(type_Id,max,min);
            NewFacility newOne = new NewFacility();
            String block_name = "G5 2828 block";
            ZipCode newZip = new ZipCode(zipCode,block_name);
            newOne.FacilityAdd(facilityId,newZip,facilityType,facilityName);
            return "Right";
        }
    }

}
