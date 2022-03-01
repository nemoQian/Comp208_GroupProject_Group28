package com.group28.dao;

import com.group28.pojo.ZipCode;
import com.group28.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * The type Test sql of zip code.
 *
 * @author Yihan Qian
 * @version 1.0
 */
public class TestSqlOfZipCode {

    /**
     * Tset select.
     */
    @Test
    public void tsetSelect(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ZipCodeDao mapper = sqlSession.getMapper(ZipCodeDao.class);

        List<ZipCode> zipCodeList = mapper.getZipCodeList();

        for(ZipCode zipCode: zipCodeList){
            System.out.println(zipCode);
        }

        sqlSession.close();
    }

    /**
     * Test select by zip code.
     */
    @Test
    public void testSelectByZipCode(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ZipCodeDao mapper = sqlSession.getMapper(ZipCodeDao.class);

        ZipCode zipCode = mapper.getZipCode("V12");
        System.out.println(zipCode);

        sqlSession.close();
    }

    /**
     * Test add zip code.
     */
    @Test
    public void testAddZipCode(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ZipCodeDao mapper = sqlSession.getMapper(ZipCodeDao.class);

        mapper.addZipCode(new ZipCode("V42","fourthBlock"));
        sqlSession.commit();
        sqlSession.close();
    }


}
