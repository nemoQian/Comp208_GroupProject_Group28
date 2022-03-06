package com.group28.service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/ajax")
public class Ajaxcontroller {

    @RequestMapping("a1")
    public void ajax(String name, HttpServletResponse response) throws IOException {
        if("admin".equals(name)){
            response.getWriter().print("true");
        }
        else{
            response.getWriter().print("false");
        }

    }
}
