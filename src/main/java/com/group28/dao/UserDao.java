package com.group28.dao;

import com.group28.pojo.User;

import java.util.List;


/**
 * The interface User dao.
 *
 * @author Yuyuan Cao
 * @version 1.0
 */
public interface UserDao {

    /**
     * Gets user list.
     *
     * @return the user list
     */
    List<User> getUserList();

    /**
     * Gets user.
     *
     * @param user_Name the user name
     * @return the user
     */
    User getUser(String user_Name);


   // User login(@Param("user_Name") String user_Name, @Param("user_Password") String user_Password);
}
