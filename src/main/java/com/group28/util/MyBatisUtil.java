package com.group28.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * This is a util to build sql session factory
 *
 * @author Yihan Qian
 */
public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            // This references the configuration under the folder resources
            String resource = "mybatis-config.xml";

            // This gives a input stream
            InputStream inputStream = Resources.getResourceAsStream(resource);

            // This creates the sql session factory via sql session factory builder
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This open the sql session
     *
     * @return the sqlSession
     */
    public static SqlSession getSqlSession() { return sqlSessionFactory.openSession(); }

}
