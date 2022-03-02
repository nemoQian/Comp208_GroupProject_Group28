package com.group28.dao;

import com.group28.pojo.User;
import com.group28.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * The type User search.
 *
 * @author Yuyuan Cao
 * @version 1.0
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

}
