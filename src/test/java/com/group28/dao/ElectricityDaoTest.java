package com.group28.dao;

import com.group28.pojo.ElectricityUnit;
import com.group28.pojo.ElectricityUnitType;
import com.group28.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class ElectricityDaoTest {
    @Test
    public void AddTypeTest(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();
        FacilityDao mapper = sqlsession.getMapper(FacilityDao.class);

        ElectricityUnit unit1 = mapper.SearchFacility("PB1S1A02");
        System.out.println(unit1);
    }
}
