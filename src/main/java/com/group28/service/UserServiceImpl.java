package com.group28.service;

import com.group28.dao.UserSearch;
import com.group28.pojo.User;

import java.util.List;

/**
 * The type User service.
 *
 * @author Yuyuan Cao, Yucheng Du
 * @version 1.1
 */
public class UserServiceImpl implements UserService {
    @Override
    public String login(String user_Name, String user_Password) {
//        //0 is null,1 is not exist,2 is incorrect,2828 is success
//        if(user_Name == null || user_Password == null||user_Name.equals("") || user_Password.equals("")){
//            return "400";
//        }

        UserSearch userSearch = new UserSearch();
        User user = userSearch.searchUser(user_Name);

        if (user == null) {
            return "401";
        }

        //user_Password = DigestUtils.md5DigestAsHex(user_Password);
        if (!user_Password.equals(user.getUser_Password())) {
            return "402";
        }

        return "200";


    }

    @Override
    public String Register (String user_Name, String user_Password, String user_Email){
        UserSearch RegisterCheck = new UserSearch();
        List<String> UserNameList = RegisterCheck.GetUserNameList();


        if (UserNameList.contains(user_Name)){
            return "403";
        }




        else {
            UserSearch RegisterExecute = new UserSearch();
            RegisterExecute.UserRegister(user_Name, user_Password, user_Email);
            return "201";
        }

    }
}
