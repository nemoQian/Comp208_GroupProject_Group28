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

    public void Put_electricityUnitType(ElectricityUnitType InsertType){
        this.electricityUnitType = InsertType;
    }

    public void Put_zipCode (ZipCode InsertCode){
        this.zipCode = InsertCode;
    }

    public void Put_electricityUnitId(String electricityUnitId){
        this.electricityUnitId = electricityUnitId;
    }

    public void Put_electricityUnitName(String electricityUnitName){
        this.electricityUnitName = electricityUnitName;
    }

    @Override
    public ElectricityUnitType getFacilityType() {
        return electricityUnitType;
    }

    @Override
    public ZipCode getZipCode() {
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
