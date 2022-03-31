package com.group28.pojo;

/**
 * The type Electricity unit extends Facility.
 *
 * @author Yihan Qian
 * @version 1.1
 */
public class ElectricityUnit extends Facility{

    private ElectricityUnitType electricityUnitType;
    private ZipCode zipCode;
    private String electricityUnitId;
    private String electricityUnitName;

    @Override
    public String toString() {
        return "ElectricityUnit{" +
                "electricityUnitType=" + electricityUnitType +
                ", zipCode=" + zipCode +
                ", electricityUnitId='" + electricityUnitId + '\'' +
                ", electricityUnitName='" + electricityUnitName + '\'' +
                '}';
    }
}
