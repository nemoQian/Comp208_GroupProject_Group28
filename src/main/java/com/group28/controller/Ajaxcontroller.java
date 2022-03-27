package com.group28.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/ajax")
public class Ajaxcontroller {


    @RequestMapping("/login")
    public  String getluser(@RequestParam(value = "Username",required = false) String username,
                           @RequestParam(value = "password",required = false) String password){
        System.out.println("username = "  + username);
        System.out.println("password = "  + password);

//        return "/index.jsp";
        return "pages/index_login/index";
    }

    @RequestMapping("/register")
    public  String getruser(@RequestParam(value = "Username",required = false) String username,
                           @RequestParam(value = "password",required = false) String password,
                            @RequestParam(value = "password",required = false) String email){
        System.out.println("username = "  + username);
        System.out.println("password = "  + password);
        System.out.println("email ="+email);
//        return "/index.jsp";
        return "pages/index_login/index";
    }

}
