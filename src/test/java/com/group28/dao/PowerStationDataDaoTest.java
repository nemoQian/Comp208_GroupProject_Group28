package com.group28.dao;

import com.group28.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class PowerStationDataDaoTest {
    @Test
    public void getAccumulatedProductivityAmount(){
        SqlSession sqlsession = MyBatisUtil.getSqlSession();

        PowerStationDataDao mapper = sqlsession.getMapper(PowerStationDataDao.class);

        int productivity = mapper.getAccumulatedProductivityAmount("2022-01-01");
        System.out.println(productivity);

        sqlsession.close();
    }
}
