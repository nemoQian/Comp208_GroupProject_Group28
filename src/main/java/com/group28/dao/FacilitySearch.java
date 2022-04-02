package com.group28.dao;

import com.group28.pojo.ElectricityUnitType;
import com.group28.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class FacilitySearch {
    public ElectricityUnitType AddType(String type_Id, int MAX_CONSUMMPTION, int MIN_CONSUMMPTION){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();
        FacilityDao mapper = sqlsession.getMapper(FacilityDao.class);

        mapper.AddType(type_Id, MAX_CONSUMMPTION, MIN_CONSUMMPTION);

        sqlsession.commit();

        ElectricityUnitType NewType = new ElectricityUnitType(type_Id, MAX_CONSUMMPTION, MIN_CONSUMMPTION);

        return  NewType;
    }
}
