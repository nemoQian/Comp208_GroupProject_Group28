package com.group28.controller;
import com.group28.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Map;


@Controller
@RestController
@RequestMapping("/ajax")
public class Ajaxcontroller {

    private UserServiceImpl userService;

    @PostMapping("/login")
    public  String getluser(@RequestParam(value = "Username",required = false) String username,
                           @RequestParam(value = "password",required = false) String password){
        userService = new UserServiceImpl();
        String statCode = userService.login(username, password);
        System.out.println("username = "  + username);
        System.out.println("password = "  + password);
        System.out.println(statCode);


        return statCode;
    }

    @RequestMapping("/register")
    public String getruser(@RequestParam(value = "Username",required = false) String username,
                           @RequestParam(value = "password",required = false) String password,
                            @RequestParam(value = "email",required = false) String email){
        userService = new UserServiceImpl();
        String statCode = userService.Register(username, password,email);
        System.out.println("username = "  + username);
        System.out.println("password = "  + password);
        System.out.println("email = " + email);
        System.out.println(statCode);

        return statCode;
    }
    @RequestMapping("/position")
    public void getposition(@RequestParam(value = "type",required = false) String type,
                            @RequestParam(value = "name",required = false) String name,
                            @RequestParam(value = "x",required = false) String x,
                            @RequestParam(value = "y",required = false) String y,
                            @RequestParam(value = "consumption",required = false) String consumption){
        System.out.println("type = " +type);
        System.out.println("name = " + name);
        System.out.println("x = "+x);
        System.out.println("y = "+y);
        System.out.println("consumption = "+consumption);
    }
}
