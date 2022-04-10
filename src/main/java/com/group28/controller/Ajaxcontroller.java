package com.group28.controller;
import com.group28.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Map;
import com.group28.controller.Position;
import com.group28.controller.line;
@Controller
@RestController
@RequestMapping("/ajax")
public class Ajaxcontroller {


    private UserServiceImpl userService;
    ArrayList <Position> positionArrayList= new ArrayList();
    ArrayList <line> lineArrayList= new ArrayList();

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
                            @RequestParam(value = "x",required = false) int x,
                            @RequestParam(value = "y",required = false) int y,
                            @RequestParam(value = "consumption",required = false) String consumption){


        Position position = new Position(type,name,x,y,consumption);
        positionArrayList.add(position);
        System.out.println("add");
        printarray(positionArrayList);

    }

    @RequestMapping("/reset")
    public void reset(){

            positionArrayList.clear();

        System.out.println("reset");
    }

    @RequestMapping("/rollback")
    public void rollback(){
        positionArrayList.remove(positionArrayList.size()-1);
        System.out.println("rollbcak");
        printarray(positionArrayList);
    }

    @RequestMapping("/done")
    public int[] drawline(){
         int array[] =new int []{0,0,100,200,100,200,400,150};
        return array;
    }

    public void printarray(ArrayList<Position> pa){
        Position P =  new Position();
        for (int i = 0; i < pa.size(); i++) {
            System.out.print(" "+i+" ");
            P.printp(pa.get(i));
        }
    }

}
