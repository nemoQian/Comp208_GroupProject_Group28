package com.group28.pojo;

/**
 * The type Power station extends Facility.
 *
 * @author Yihan Qian
 * @version 1.1
 */
public class PowerStation extends Facility{

    private ZipCode zipCode;
    private PowerStationType powerStationType;
    private String powerStationId;
    private String powerStationName;

    /**
     * Gets zip code.
     *
     * @return the zip code
     */
    @Override
    public ZipCode getZipCode() {
        return zipCode;
    }

    /**
     * Gets power station type.
     *
     * @return the power station type
     */
    public PowerStationType getPowerStationType() {
        return powerStationType;
    }

    /**
     * Gets power station id.
     *
     * @return the power station id
     */
    public String getPowerStationId() {
        return powerStationId;
    }

    /**
     * Gets power station name.
     *
     * @return the power station name
     */
    public String getPowerStationName() {
        return powerStationName;
    }

    @Override
    public String toString() {
        return "PowerStation{" +
                "zipCode=" + zipCode +
                ", powerStationType=" + powerStationType +
                ", powerStationId=" + powerStationId +
                ", powerStationName='" + powerStationName + '\'' +
                '}';
    }
}
