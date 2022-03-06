package com.group28.dao;

import com.group28.pojo.User;

import java.util.List;


/**
 * The interface User dao.
 *
 * @author Yuyuan Cao, Yucheng Du
 * @version 1.1
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

    /**
     * Gets username's list.
     *
     *
     * @return the username's list
     */
    List<String> GetUserNameList();


    /**
     * insert new user into DB.
     *
     *
     * @return insert success or failed
     */
    void Register(User user);

}
