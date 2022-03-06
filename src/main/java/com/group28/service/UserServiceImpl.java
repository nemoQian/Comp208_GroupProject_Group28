package com.group28.service;

import com.group28.dao.UserSearch;
import com.group28.pojo.User;

/**
 * The type User service.
 *
 * @author Yuyuan Cao
 * @version 1.0
 */
public class UserServiceImpl implements UserService {
    @Override
    public String login(String user_Name, String user_Password) {
        //0 is null,1 is not exist,2 is incorrect,2828 is success
        if(user_Name == null || user_Password == null||user_Name == "" || user_Password == ""){
            return "null";
        }

            UserSearch userSearch = new UserSearch();
            User user = userSearch.searchUser(user_Name);

            if (user == null) {
                return "user is not exit";
            }

            //user_Password = DigestUtils.md5DigestAsHex(user_Password);
            if (!user_Password.equals(user.getUser_Password())) {
                return "password is not correct";
            }

            return "True";

    }
}
