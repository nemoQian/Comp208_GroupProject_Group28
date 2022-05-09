package com.group28.pojo;

/**
 * The type Power station extends Facility.
 *
 * @author Lingfang Li
 * @version 1.1
 */
public class PowerStation extends Facility{

    private String powerStationId;
    private String zipCode;
    private String powerStationType;
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

    public void Put_powerStationId(String powerStationId){
        this.powerStationId = powerStationId;
    }

    public void Put_zipCode(String zipCode){
        this.zipCode = zipCode;
    }

    public void Put_powerStationType(String powerStationType){
        this.powerStationType = powerStationType;
    }

    public void Put_powerStationName(String powerStationName){
        this.powerStationName = powerStationName;
    }

    @Override
    public String getFacilityType() {
        return powerStationType;
    }

    @Override
    public String getZipCode() {
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
