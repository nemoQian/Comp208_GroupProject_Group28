package com.group28.controller;
import com.group28.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/ajax")
public class Ajaxcontroller {

    private UserServiceImpl userService;

    @RequestMapping("/login")
    public  String getluser(@RequestParam(value = "Username",required = false) String username,
                           @RequestParam(value = "password",required = false) String password){
        userService = new UserServiceImpl();
        String statCode = userService.login(username, password);
        System.out.println("username = "  + username);
        System.out.println("password = "  + password);
        System.out.println(statCode);

//        return "/index.jsp";
        return "pages/index_login/index";
    }

    @RequestMapping("/register")
    public  String getruser(@RequestParam(value = "Username",required = false) String username,
                           @RequestParam(value = "password",required = false) String password,
                            @RequestParam(value = "email",required = false) String email){
        userService = new UserServiceImpl();
        String statCode = userService.Register(username, password,email);
        System.out.println("username = "  + username);
        System.out.println("password = "  + password);
        System.out.println("email = " + email);
        System.out.println(statCode);

        return "pages/index_login/index";
    }

}
