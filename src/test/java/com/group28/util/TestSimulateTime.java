package com.group28.util;

import org.junit.Test;

import java.util.Scanner;

/**
 * The type Test simulate time.
 *
 * @author Yihan Qian
 */
public class TestSimulateTime implements Runnable {

    /**
     * The Simulate time.
     */
    static SimulateTime simulateTime = new SimulateTime();

    /**
     * Test simulate time.
     */
    @Test
    public void testSimulateTime(){
        TestSimulateTime test = new TestSimulateTime();

        Thread t1 = new Thread(test);
        t1.start();

        boolean s = true;
        Scanner scanner = new Scanner(System.in);


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
            else if(a == 4){
                s = false;
            }
        }

        simulateTime.simulationStop();
        t1.interrupt();
    }

    @Override
    public void run(){
        simulateTime.simulationOpen();
    }

}
