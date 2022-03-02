package com.group28.service;


/**
 * The interface User service.
 *
 * @author Yuyuan Cao
 * @version 1.0
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
}
