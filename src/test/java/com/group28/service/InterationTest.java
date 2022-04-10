package com.group28.service;

import org.junit.Test;

import java.util.Scanner;

public class InterationTest {
    Interation interation = new Interation();
    @Test
    public void addNewFacilityTest(){
        System.out.println(interation.addNewFacility("PowerStation",
                "New powers", 500, 300, "FI"));

        System.out.println(interation.addNewFacility("PowerStation",
                "New powers", 520, 330, "FI"));

        System.out.println(interation.addNewFacility("PowerStation",
                "New powers", 620, 330, "FI"));

        System.out.println(interation.addNewFacility("PowerStation",
                "New powerst", 620, 330, "FI"));

        System.out.println(interation.addNewFacility("Hospital",
                "HD", 234, 544, "AP1"));

        interation.worldSimulationOpen();
    }

    public static void main(String[] args){
        Interation interation = new Interation();
        System.out.println(interation.addNewFacility("PowerStation",
                "New powers", 500, 300, "FI")); // 1

        System.out.println(interation.addNewFacility("PowerStation",
                "New powers", 520, 330, "FI")); // -1

        System.out.println(interation.addNewFacility("PowerStation",
                "New powers", 620, 330, "FI")); // -1

        System.out.println(interation.addNewFacility("PowerStation",
                "New powerst", 620, 330, "FI")); // 1

        System.out.println(interation.addNewFacility("Hospital",
                "HD", 234, 544, "AP1")); // 1

        interation.worldSimulationOpen();
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
                int[] aaa = interation.prim();
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
