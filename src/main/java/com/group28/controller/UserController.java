package com.group28.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class UserController {
    @RequestMapping("/")
    public String toindex(){
        return "pages/index_login/index";
    }
}
