package com.group28.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/ajax")
public class Ajaxcontroller {


    @RequestMapping("/a1")
    public  String getuser(@RequestParam(value = "Username",required = false) String username,
                           @RequestParam(value = "password",required = false) String password){
        System.out.println("username = "  + username);
        System.out.println("password = "  + password);

//        return "/index.jsp";
        return "pages/index_login/index";
    }

}
