package com.group28.pojo;

/**
 * The type Electricity unit type.
 *
 * @author Yihan Qian
 */
public class ElectricityUnitType {

    private String electricityUnitType;
    private int MAX_CONSUMPTION;
    private int MIN_CONSUMPTION;

    /**
     * Instantiates a new Electricity unit type.
     */
    public ElectricityUnitType() {
    }

    /**
     * Instantiates a new Electricity unit type.
     *
     * @param electricityUnitType the electricity unit type
     * @param MAX_CONSUMPTION     the max consumption
     * @param MIN_CONSUMPTION     the min consumption
     */
    public ElectricityUnitType(String electricityUnitType, int MAX_CONSUMPTION, int MIN_CONSUMPTION) {
        this.electricityUnitType = electricityUnitType;
        this.MAX_CONSUMPTION = MAX_CONSUMPTION;
        this.MIN_CONSUMPTION = MIN_CONSUMPTION;
    }

    /**
     * Gets electricity unit type.
     *
     * @return the electricity unit type
     */
    public String getElectricityUnitType() {
        return electricityUnitType;
    }

    /**
     * Sets electricity unit type.
     *
     * @param electricityUnitType the electricity unit type
     */
    public void setElectricityUnitType(String electricityUnitType) {
        this.electricityUnitType = electricityUnitType;
    }

    /**
     * Gets max consumption.
     *
     * @return the max consumption
     */
    public int getMAX_CONSUMPTION() {
        return MAX_CONSUMPTION;
    }

    /**
     * Sets max consumption.
     *
     * @param MAX_CONSUMPTION the max consumption
     */
    public void setMAX_CONSUMPTION(int MAX_CONSUMPTION) {
        this.MAX_CONSUMPTION = MAX_CONSUMPTION;
    }

    /**
     * Gets min consumption.
     *
     * @return the min consumption
     */
    public int getMIN_CONSUMPTION() {
        return MIN_CONSUMPTION;
    }

    /**
     * Sets min consumption.
     *
     * @param MIN_CONSUMPTION the min consumption
     */
    public void setMIN_CONSUMPTION(int MIN_CONSUMPTION) {
        this.MIN_CONSUMPTION = MIN_CONSUMPTION;
    }

    @Override
    public String toString() {
        return "ElectricityUnitType{" +
                "electricityUnitType='" + electricityUnitType + '\'' +
                ", MAX_CONSUMPTION=" + MAX_CONSUMPTION +
                ", MIN_CONSUMPTION=" + MIN_CONSUMPTION +
                '}';
    }
}
