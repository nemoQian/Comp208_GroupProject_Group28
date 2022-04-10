package com.group28.controller;

public class Position {

    String type;
    String name;
    int x;
    int y;
    String consumption;
    Position(String type,String name,int x,int y,String consumption){
        this.consumption=consumption;
        this.type=type;
        this.name=name;
        this.x=x;
        this.y=y;
    }
    Position(){}

    public void printp(Position position){
        System.out.print("type = " +position.type);
        System.out.print("  name = " + position.name);
        System.out.print("  x = "+position.x);
        System.out.print("  y = "+position.y);
        System.out.println("  consumption = "+position.consumption);
    }


}
