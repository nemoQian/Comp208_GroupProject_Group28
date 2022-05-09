package com.group28.controller;
import com.group28.service.Interation;
import com.group28.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Arrays;
@Controller
@RestController
@RequestMapping("/ajax")

public class Ajaxcontroller {


    public UserServiceImpl userService;
    ArrayList <Position> positionArrayList= new ArrayList();
    public static Interation interation = new Interation();
    String ifGuest = "notguest";
    int numPower = 0;
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
    @RequestMapping("/guest-login")
    public void guestlogin(@RequestParam(value = "ifguest",required = false) String ifguest){
        this.ifGuest = ifguest;
        System.out.println(this.ifGuest);
    }
    @RequestMapping("/position")
    public String getposition(@RequestParam(value = "type",required = false) String type,
                              @RequestParam(value = "name",required = false) String name,
                              @RequestParam(value = "x",required = false) int x,
                              @RequestParam(value = "y",required = false) int y,
                              @RequestParam(value = "consumption",required = false) String consumption){
        Position position = new Position(type,name,x,y,consumption);

        if(positionArrayList.size() < 1){
            positionArrayList.add(position);
            System.out.println("add");
            printarray(positionArrayList);
            return "insert success";
        }
        else {
            for(Position p : positionArrayList){
                if(name.equals(p.name)){
                    System.out.println("name repeat");
                    return "This name has existed";
                }
                if(x == p.x && y == p.y){
                    System.out.println("position occupied");
                    return "There is already a building on this site.";
                }
            }
        }
        positionArrayList.add(position);
        System.out.println("add");
        printarray(positionArrayList);
        return "insert success";
    }

    @RequestMapping("/reset")
    public void reset(){
        interation.worldSimulationReset();
        positionArrayList.clear();
        interation = new Interation();
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
        int numOfPowerstation = 0;
        for(int i = 0; i < positionArrayList.size(); i++){
            if(positionArrayList.get(i).type.equals("Power station")){
                numOfPowerstation ++;
            }
            System.out.println(interation.addNewFacility(positionArrayList.get(i).type,
                    positionArrayList.get(i).name,
                    positionArrayList.get(i).x,
                    positionArrayList.get(i).y,
                    positionArrayList.get(i).consumption));
        }
        if(numOfPowerstation == 0){
            System.out.println("没有发电站");
            return new int[]{-1};
        }
        int[] array = interation.prim();
        int[] a = interation.worldSimulationOpen();
        if(a[0] == 1){
            System.out.println("开启成功");
        }
        else if(a[0] == -1){
            System.out.println("用电大于发电");
            return new int[]{-2};
        }
        return array;
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
        a.part3 = "Total Consumption";
        a.kw3 = interation.getTotalConsumption();
        a.part4 = "Total Production";
        a.kw4 = interation.getTotalProduction();
        a.part = "Total Best Loss";
        a.kw = interation.getTotalBestLoss();
        a.part2 = "Total Worst Loss";
        a.kw2 = interation.getTotalWorstLoss();
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
        ArrayList<Object> aa = new ArrayList<Object>();
        aa.add(interation.getTime());
        aa.add(interation.getCurrentProduction());
        int[] linar = interation.getLineChart();
        aa.add(linar[0]);
        aa.add(linar[1]);
        aa.add(linar[2]);
        aa.add(linar[3]);
        return aa; //返回一个json对象
    }

    @RequestMapping("/alljoin")
    public int [] returnalljoin(){
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < positionArrayList.size(); i++) {
            Position itemi = positionArrayList.get(i);
            for (int j = i+1; j < positionArrayList.size(); j++) {
                Position itemj = positionArrayList.get(j);
                array.add(itemi.x);
                array.add(itemi.y);
                array.add(itemj.x);
                array.add(itemj.y);
            }
        }
        return arraylisttoarray(array);
    }

    public int [] arraylisttoarray(ArrayList<Integer> arrayList){
        int array[] = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            array[i]=arrayList.get(i);
        }
        return array;
    }

}
