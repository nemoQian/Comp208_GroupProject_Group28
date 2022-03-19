package com.group28.dao;

import com.group28.pojo.User;
import com.group28.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


/**
 * The type Test user dao.
 *
 * @author Yuyuan Cao
 * @version 1.0
 */
public class TestUserDao {
    /**
     * Test select.
     */
    @Test
    public void tsetSelect(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        List<User> UserList = mapper.getUserList();
        List<String> UserNameList = mapper.GetUserNameList();

        for(User user: UserList){
            System.out.println(user);
        }
        for (String name: UserNameList){
            System.out.println(name);
        }

        sqlSession.close();
    }

    /**
     * Test user search.
     */
    @Test
    public void testUserSearch(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        User user = mapper.getUser("Zsh");

        System.out.println(user);
        sqlSession.close();
    }
}
