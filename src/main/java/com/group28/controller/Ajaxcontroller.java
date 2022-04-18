package com.group28.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group28.service.Interation;
import com.group28.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import com.group28.controller.Position;
import com.group28.controller.echart_1;
import com.group28.controller.line;
@Controller
@RestController
@RequestMapping("/ajax")

public class Ajaxcontroller {


    private UserServiceImpl userService;
    ArrayList <Position> positionArrayList= new ArrayList();

    private static Interation interation = new Interation();

    @PostMapping("/login")
    public String getluser(@RequestParam(value = "Username",required = false) String username,
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
    public int getposition(@RequestParam(value = "type",required = false) String type,
                           @RequestParam(value = "name",required = false) String name,
                           @RequestParam(value = "x",required = false) int x,
                           @RequestParam(value = "y",required = false) int y,
                           @RequestParam(value = "consumption",required = false) String consumption){
        Position position = new Position(type,name,x,y,consumption);
        if(positionArrayList.size() < 1){
            positionArrayList.add(position);
            System.out.println("add");
            printarray(positionArrayList);
            return 1;
        }
        else {
            for(Position p : positionArrayList){
                if(name.equals(p.name)){
                    System.out.println("名字重复");
                    return -1;
                }
                if(x == p.x && y == p.y){
                    System.out.println("位置占用");
                    return -2;
                }
            }
        }
        positionArrayList.add(position);
        System.out.println("add");
        printarray(positionArrayList);
        return 1;
    }

    @RequestMapping("/reset")
    public void reset(){
        interation.worldSimulationReset();
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
        for(int i = 0; i < positionArrayList.size(); i++){
            System.out.println(interation.addNewFacility(positionArrayList.get(i).type,
                    positionArrayList.get(i).name,
                    positionArrayList.get(i).x,
                    positionArrayList.get(i).y,
                    positionArrayList.get(i).consumption));
        }
        int array[] = interation.prim();
        System.out.println(Arrays.toString(array));
        System.out.println(interation.worldSimulationOpen());
        return array;
//        return new int[]{100,100,232,123,232,123,400,200};
    }

    public void printarray(ArrayList<Position> pa){
        Position P =  new Position();
        for (int i = 0; i < pa.size(); i++) {
            System.out.print(" "+i+" ");
            P.printp(pa.get(i));
        }
    }



    @RequestMapping("/test")
    public echart_1 chart_2(){
        echart_1 a = new echart_1();
        a.part = "Total Consumption";
        a.kw = interation.getTotalConsumption();
        a.part2 = "Total Production";
        a.kw2 = interation.getTotalProduction();
        return a; //返回一个json对象
    }

    @RequestMapping("/test3")
    public ArrayList<ArrayList<Integer>> chart_3(){
        return interation.getHeightList(); //返回一个json对象
    }

    @RequestMapping("/test4")
    public int[] chart_4(){
        //代表功率：["Community","Hospital","School","Station","Shop"]
        return interation.getFanChart();
    }

    @RequestMapping("/test5")
    public ArrayList<Object> chart_5(){
        ArrayList<Object> aa = new ArrayList<>();
        aa.add(interation.getTime());
        aa.add(interation.getCurrentProduction());
        aa.add(interation.getCurrentConsumption());
        return aa; //返回一个json对象
    }

}
