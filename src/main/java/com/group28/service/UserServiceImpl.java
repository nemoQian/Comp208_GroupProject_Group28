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

        return "G5 2828";


    }

    @Override
    public String Register (String user_Name, String user_Password, String user_Email){
        UserSearch RegisterCheck = new UserSearch();
        List<String> UserNameList = RegisterCheck.GetUserNameList();


        if (UserNameList.contains(user_Name)){
            return "User Already Exist, Register Failed";
        }

        else if (user_Name == null || user_Password == null || user_Email == null){
            return "Please input your user name, password and email";
        }

        else if (user_Name.equals("") || user_Password.equals("") || user_Email.equals("")){
            return "Please input your user name, password and email";
        }


        else {
            UserSearch RegisterExecute = new UserSearch();
            RegisterExecute.UserRegister(user_Name, user_Password, user_Email);
            return "Register Success!";
        }

    }
}
