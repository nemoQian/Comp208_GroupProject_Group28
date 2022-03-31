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

    @Override
    public String toString() {
        return "PowerStation{" +
                "zipCode=" + zipCode +
                ", powerStationType=" + powerStationType +
                ", powerStationId=" + powerStationId +
                ", powerStationName='" + powerStationName + '\'' +
                '}';
    }

    @Override
    public PowerStationType getFacilityType() {
        return powerStationType;
    }

    @Override
    public ZipCode getZipCode() {
        return zipCode;
    }

    @Override
    public String getFacilityId() {
        return powerStationId;
    }

    @Override
    public String getFacilityName() {
        return powerStationName;
    }
}
