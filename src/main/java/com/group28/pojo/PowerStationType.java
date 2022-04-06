package com.group28.pojo;

/**
 * The type Power station type extends FacilityType.
 *
 * @author Yihan Qian
 * @version 1.0
 */
public class PowerStationType extends FacilityType{

    private String type_Id;
    private int MAX_PRODUCTION;


    @Override
    public String getType_Id() {
        return type_Id;
    }

    @Override
    public int getMAX_NUMERICAL() {
        return MAX_PRODUCTION;
    }

    @Override
    public String toString() {
        return "PowerStationType{" +
                "TYPE_ID='" + type_Id + '\'' +
                ", MAX_PRODUCTION=" + MAX_PRODUCTION +
                '}';
    }

    public void  Put_type_Id(String type_Id){
        this.type_Id = type_Id;
    }

    public void  Put_MAX_PRODUCTION(int MAX_PRODUCTION){
        this.MAX_PRODUCTION = MAX_PRODUCTION;
    }
}
