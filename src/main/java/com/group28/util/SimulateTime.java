package com.group28.util;

import java.util.ArrayList;

/**
 * The type Simulate time.
 *
 * @author Yihan Qian
 * @version 1.0
 */
public class SimulateTime implements SimulateTimeInterface {
    private static String[][] JANUARY = new String[31][24];
    private static String[][] FEBRUARY = new String[29][24];
    private static String[][] MARCH = new String[31][24];
    private static String[][] APRIL = new String[30][24];
    private static String[][] MAY = new String[31][24];
    private static String[][] JUNE = new String[30][24];
    private static String[][] JULY = new String[31][24];
    private static String[][] AUGUST = new String[31][24];
    private static String[][] SEPTEMBER = new String[30][24];
    private static String[][] OCTOBER = new String[31][24];
    private static String[][] NOVEMBER = new String[30][24];
    private static String[][] DECEMBER = new String[31][24];

    private static ArrayList<String[][]> MONTH;
    private static final int HOUR = 23;
    private static final int MINUTE = 59;
    private static final int SECOND = 60;
    private static long year = 2022;

    private static int second = 0;
    private static int minute = 0;
    private static int hour = 0;
    private static int day = 1;
    private static int month = 1;

    private static boolean flag = true;
    private final int CRITICAL_VALUE = 10;

    static {
        MONTH = new ArrayList<String[][]>();
        MONTH.add(JANUARY);
        MONTH.add(FEBRUARY);
        MONTH.add(MARCH);
        MONTH.add(APRIL);
        MONTH.add(MAY);
        MONTH.add(JUNE);
        MONTH.add(JULY);
        MONTH.add(AUGUST);
        MONTH.add(SEPTEMBER);
        MONTH.add(OCTOBER);
        MONTH.add(NOVEMBER);
        MONTH.add(DECEMBER);
    }

    /**
     * Instantiates a new Simulate time.
     */
    public SimulateTime()  {

    }

    @Override
    public void simulationOpen() {
        flag = true;
        System.out.println("Time simulation open!");
        MONTH.get(month-1)[day-1][hour] = year*1000000 + 10000 + 100 + 0 + "";
        System.out.println(MONTH.get(month - 1)[day - 1][hour]);
        while (flag){
            simulateSeconds();
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Time simulation stop!");
    }

    @Override
    public void simulationStop(){
        flag = false;
    }

    @Override
    public void simulateSeconds(){
        if(second == SECOND){
            second = 0;
            simulateMinutes();
        }
        else{
            second += 1;
        }
    }

    @Override
    public void simulateMinutes(){
        if(minute == MINUTE){
            minute = 0;
            simulateHours();
        }
        else{
            minute += 1;
            System.out.println(minute);
        }
    }

    @Override
    public void simulateHours(){
        if(hour == HOUR){
            hour = 0;
            simulateDays();
        }
        else {
            MONTH.get(month-1)[day-1][hour+1] = year*1000000 + month*10000 + day*100 + (hour+1) + "";
            System.out.println(MONTH.get(month - 1)[day - 1][hour]);
            hour += 1;
        }
    }

    @Override
    public void simulateDays(){
        if(day == MONTH.get(month-1).length){
            day = 1;
            simulateMonths();
        }
        else {
            day += 1;
        }
    }

    @Override
    public void simulateMonths(){
        if (month == MONTH.size()){
            month = 1;
            year += 1;
        }
        else {
            month += 1;
        }
    }

    @Override
    public int getHour(){
        return hour;
    }

    @Override
    public int getDay(){
        return day;
    }

    @Override
    public int getMonth(){
        return month;
    }

    @Override
    public long getYear(){
        return year;
    }

    @Override
    public String getTimeNow(){
        String monthString = "";
        String dayString = "";
        String hourString = "";
        String minuteString = "";
        String secondString = "";
        String zero = "0";
        if (month < CRITICAL_VALUE) {monthString += zero + month;}
        else {monthString += month;}
        if (day < CRITICAL_VALUE) {dayString += zero + day;}
        else {dayString += day;}
        if (hour < CRITICAL_VALUE) {hourString += zero + hour;}
        else {hourString += hour;}
        if (minute < CRITICAL_VALUE) {minuteString += zero + minute;}
        else {minuteString += minute;}
        if (second < CRITICAL_VALUE) {secondString += zero + second;}
        else {secondString += second;}

        return "" + year + " - " + monthString + " - " + dayString + " - " +
                hourString + " : " + minuteString + " : " + secondString;
    }

    @Override
    public String getFrontReferenceId(){
        return MONTH.get(month-1)[day-1][hour];
    }

}
