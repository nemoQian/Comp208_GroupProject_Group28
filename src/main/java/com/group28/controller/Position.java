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
}
