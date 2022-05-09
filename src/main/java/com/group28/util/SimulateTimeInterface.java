package com.group28.util;

/**
 * The interface Simulate time interface.
 * It simulates times 10 minute equals 6 seconds in real world.
 *
 * @author Yihan Qian
 * @version 2.0
 */
public interface SimulateTimeInterface {

    /**
     * Simulate seconds.
     */
    void simulateSeconds();

    /**
     * Simulate minutes.
     */
    void simulateMinutes();

    /**
     * Simulate hours.
     */
    void simulateHours();

    /**
     * Simulate days.
     */
    void simulateDays();

    /**
     * Simulate months.
     */
    void simulateMonths();

    /**
     * Gets hour.
     *
     * @return the hour
     */
    int getHour();

    /**
     * Gets day.
     *
     * @return the day
     */
    int getDay();

    /**
     * Gets month.
     *
     * @return the month
     */
    int getMonth();

    /**
     * Gets year.
     *
     * @return the year
     */
    long getYear();

    /**
     * Gets time now.
     * It will give the time with following format:
     * YYYY - MM - DD - HH : MM : SS
     * For example, 2022 year, January 1st, 12:30:20 will be represented as
     * 2022 - 01 - 01 - 12 : 30 : 20
     *
     * @return the time now
     */
    String getTimeNow();

    /**
     * Gets front reference id.
     * It will return the reference id which can be used
     * to search in the database
     *
     * @return the front reference id
     */
    String getFrontReferenceId();

    /**
     * Simulation open.
     */
    void simulationOpen();

    /**
     * Simulation stop.
     */
    void simulationStop();

}
