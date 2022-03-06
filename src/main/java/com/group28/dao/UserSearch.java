package com.group28.dao;

import com.group28.pojo.User;
import com.group28.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * The type User search.
 *
 * @author Yuyuan Cao, Yucheng Du
 * @version 1.1
 */
public class UserSearch {
    /**
     * Search user user.
     *
     * @param user_name the user name
     * @return the user
     */
    public User searchUser(String user_name){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = mapper.getUser(user_name);
        sqlSession.close();
        return user;
    }

    /**
     * Get the List of username.
     *
     *
     * @return the username's list
     */
    public List<String> GetUserNameList() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        List<String> NameList = mapper.GetUserNameList();

        sqlSession.close();
        return  NameList;
    }


    public void UserRegister(String user_Name, String user_Password, String user_Email){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        User registeruser = new User(user_Name, user_Password, user_Email);


        mapper.Register(registeruser);

        sqlSession.commit();
        System.out.println("Data inserted");
        System.out.println("New User:" + registeruser);
    }

}
