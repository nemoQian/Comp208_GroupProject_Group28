package com.group28.util;

import com.group28.pojo.Facility;

/**
 * The interface Simulate map interface.
 *
 * @author Yihan Qian
 * @version 2.0
 */
public interface SimulateMapInterface {

    /**
     * Add new facility int.
     *
     * @param facility the facility
     * @param location the location
     * @return the int
     */
    int addNewFacility (Facility facility, int[] location);

    /**
     * Get facility location int [ ].
     *
     * @param facility the facility
     * @return the int [ ]
     */
    int[] getFacilityLocation (Facility facility);

    /**
     * Gets distance by Manhattan distance.
     *
     * @param facility1 the facility 1
     * @param facility2 the facility 2
     * @return the distance
     */
    int getDistance(Facility facility1, Facility facility2);

}
