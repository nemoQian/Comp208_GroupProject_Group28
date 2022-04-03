package com.group28.dao;

import com.group28.pojo.ElectricityUnitType;
import com.group28.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class FacilitySearch {
    public void AddType(String type_Id, int MAX_CONSUMMPTION, int MIN_CONSUMMPTION){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();
        FacilityDao mapper = sqlsession.getMapper(FacilityDao.class);

        ElectricityUnitType NewType = new ElectricityUnitType();

        NewType.PutTypeId(NewType, type_Id);

        NewType.PutMAX_CONSUMMPTION(NewType, MAX_CONSUMMPTION);

        NewType.PutMIN_CONSUMMPTION(NewType, MIN_CONSUMMPTION);

        mapper.AddType(NewType);

        sqlsession.commit();

        System.out.println(NewType);
    }

    
}
