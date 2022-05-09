package com.group28.pojo;

/**
 * The type Electricity unit extends Facility.
 *
 * @author Yucheng Du
 * @version 1.1
 */
public class ElectricityUnit extends Facility{

    private String electricityUnitId;
    private String zipCode;
    private String electricityUnitType;
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

    public void Put_electricityUnitType(String InsertType){
        this.electricityUnitType = InsertType;
    }

    public void Put_zipCode (String InsertCode){
        this.zipCode = InsertCode;
    }

    public void Put_electricityUnitId(String electricityUnitId){
        this.electricityUnitId = electricityUnitId;
    }

    public void Put_electricityUnitName(String electricityUnitName){
        this.electricityUnitName = electricityUnitName;
    }

    @Override
    public String getFacilityType() {
        return electricityUnitType;
    }

    @Override
    public String getZipCode() {
        return zipCode;
    }

    @Override
    public String getFacilityId() {
        return electricityUnitId;
    }

    @Override
    public String getFacilityName() {
        return electricityUnitName;
    }
}
