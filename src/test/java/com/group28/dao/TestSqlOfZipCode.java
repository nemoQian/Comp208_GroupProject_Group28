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

        for(int i = 1; i <= 16; i++){
            for(int j = 1; j<=9; j++){
                String a = "";
                if(i < 10){
                    if( j < 10){
                        a = "S0" + i + " A0" + j;
                    }
                    else { a = "S0" + i + " A" + j; }
                }
                else {
                    if (j < 10) {
                        a = "S" + i + " A0" + j;
                    } else {
                        a = "S" + i + " A" + j;
                    }
                }
                mapper.addZipCode(new ZipCode(a,a));
            }
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void GetCodeListTest(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ZipCodeDao mapper = sqlSession.getMapper(ZipCodeDao.class);

        List<String> CodeList = mapper.getZipCode_CodeList();

        System.out.println(CodeList);

        sqlSession.close();
    }

    @Test
    public void testDropZipCode(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ZipCodeDao mapper = sqlSession.getMapper(ZipCodeDao.class);

        mapper.DeleteZipCode("V42");
        sqlSession.commit();
        sqlSession.close();
    }


}
