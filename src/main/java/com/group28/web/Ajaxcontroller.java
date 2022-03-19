package com.group28.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/ajax")
public class Ajaxcontroller {

//    @RequestMapping("a1")
//    public void ajax(String name, HttpServletResponse response) throws IOException {
//        if("admin".equals(name)){
//            response.getWriter().print("true");
//        }
//        else{
//            response.getWriter().print("false");
//        }
//
//    }
    @RequestMapping("/a1")
    public static String usernamew(String username){
        return username;
    }
//    public static void main(String[] args) {
//        String name = "sdfsd";
//        System.out.println(usernamew(name));
//    }
}
