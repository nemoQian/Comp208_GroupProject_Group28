package com.group28.dao;

import java.util.List;
import com.group28.pojo.ZipCode;
import com.group28.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;


public class ZipCodeSearch {
    public void AddNewCode(String zipCode, String BlockName){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ZipCodeDao mapper = sqlSession.getMapper(ZipCodeDao.class);

        ZipCode NewCode = new ZipCode(zipCode, BlockName);

        List<String> CodeList = mapper.getZipCode_CodeList();

        if (!(CodeList.contains(zipCode))){
            mapper.addZipCode(NewCode);
        }

        else {
            System.out.println("Primary Key rule break");
        }
    }
}
