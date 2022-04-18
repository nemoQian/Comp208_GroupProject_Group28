package com.group28.service;

import org.junit.Test;

import java.util.Scanner;

public class InterationTest {
    Interation interation = new Interation();
    @Test
    public void addNewFacilityTest(){
        System.out.println(interation.addNewFacility("PowerStation",
                "New powers", 500, 300, "PSL"));

        System.out.println(interation.addNewFacility("PowerStation",
                "New powers", 520, 330, "FI"));

        System.out.println(interation.addNewFacility("PowerStation",
                "New powers", 620, 330, "FI"));

        System.out.println(interation.addNewFacility("PowerStation",
                "New powerst", 620, 330, "PSM"));

        System.out.println(interation.addNewFacility("Hospital",
                "HD", 234, 544, "HOL"));

        interation.worldSimulationOpen();
    }

    public static void main(String[] args){
        Interation interation = new Interation();

        System.out.println(interation.addNewFacility("Power station",
                "New powers", 238, 165, "high-level")); // 1

        System.out.println(interation.addNewFacility("Power station",
                "New powers", 238, 165, "high-level")); // -1

        System.out.println(interation.addNewFacility(" Power station",
                "New powers", 288, 165, "low-level")); // -1

        System.out.println(interation.addNewFacility("Power station",
                "New powerst", 288, 165, "high-level")); // 1

        System.out.println(interation.addNewFacility("Community",
                "HD", 88, 265, "medium-level")); // 1

        System.out.println(interation.addNewFacility("Shopping centre",
                "HDa", 38, 115, "low-level")); // 1

        System.out.println(interation.addNewFacility("Shopping centre",
                "HDaa", 138, 115, "low-level")); // 1

        interation.worldSimulationOpen();
        int[] aaa = interation.prim();
        boolean s = true;
        Scanner scanner = new Scanner(System.in);

        while (s) {
            int a = scanner.nextInt();
            if(a == 1){
                System.out.println(interation.getTotalConsumption());
            } else if (a == 2) {
                System.out.println(interation.getTotalProduction());
            }
            else if(a == 3){

                for (int i = 0; i<aaa.length; i++){
                    System.out.print(aaa[i] + " ");
                }
            }
            else if(a == 4){
                System.out.println(interation.getLose());
            }
        }
    }
}
