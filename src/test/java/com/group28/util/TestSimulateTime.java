package com.group28.util;

import java.util.Scanner;

/**
 * The type Test simulate time.
 *
 * @author Yihan Qian
 */
public class TestSimulateTime{

    /**
     * The Simulate time.
     */
    static SimulateTime simulateTime = new SimulateTime();


    public static void main(String[] args) {
        boolean s = true;
        Scanner scanner = new Scanner(System.in);

        new Thread("t1"){
            public void run(){
                simulateTime.simulationOpen();
            };
        }.start();

        new Thread("t2") {
            int timeNow = simulateTime.getHour();
            public void run() {
                while(true){
                    if(simulateTime.getHour() > timeNow){
                        System.out.println("hhhh" + simulateTime.getTimeNow());
                        timeNow = simulateTime.getHour();
                    }
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
        }.start();

        while (s){
            int a = scanner.nextInt();
            if(a == 1){
                System.out.println(simulateTime.getTimeNow());
            }
            else if(a == 2){
                System.out.println(simulateTime.getFrontReferenceId());
            }
            else if(a == 3){
                System.out.println(simulateTime.getHour());
            }
            else if(a == 5){
                System.out.println(simulateTime.getThreadName());
            }
            else if(a == 4){
                s = false;
            }
        }

        simulateTime.simulationStop();
    }

}
