package com.group28.util;

import org.junit.Test;

/**
 * The type Test simulate map.
 *
 * @author Yihan Qian
 * @version 1.0
 */
public class TestSimulateMap {

    private static SimulateMap map = new SimulateMap(10,10);

    /**
     * Test energy matrix.
     */
    @Test
    public void testEnergyMatrix(){
        int[][] energyMatrix = map.getEnergyMatrix();

        for (int[] row : energyMatrix){
            for (int col : row){
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
