package com.group28.service;


/**
 * The interface User service.
 *
 * @author Yuyuan Cao, Yucheng Du
 * @version 1.1
 */
public interface UserService {
    /**
     * Login string.
     *
     * @param user_Name     the user name
     * @param user_Password the user password
     * @return the string
     */
    String login(String user_Name, String user_Password);

    String Register (String User_Name, String User_Password, String User_Email);
}
