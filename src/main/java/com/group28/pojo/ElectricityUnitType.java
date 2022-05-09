package com.group28.pojo;

/**
 * The type Electricity unit type extends FacilityType.
 *
 * @author Yucheng Du
 * @version 1.0
 */
public class ElectricityUnitType extends FacilityType{
    private String type_Id;
    private int MAX_CONSUMMPTION;
    private int MIN_CONSUMMPTION;



    @Override
    public String toString() {
        return "ElectricityUnitType{" +
                "type_Id='" + type_Id + '\'' +
                ", MAX_CONSUMMPTION=" + MAX_CONSUMMPTION +
                ", MIN_CONSUMMPTION=" + MIN_CONSUMMPTION +
                '}';
    }

    public void PutTypeId(String Id){
        this.type_Id = Id;
    }

    public void PutMAX_CONSUMMPTION(int MAX_CONSUMMPTION){
        this.MAX_CONSUMMPTION = MAX_CONSUMMPTION;
    }

    public void PutMIN_CONSUMMPTION(int MIN_CONSUMMPTION){
        this.MIN_CONSUMMPTION = MIN_CONSUMMPTION;
    }

    @Override
    public String getType_Id() {
        return type_Id;
    }

    @Override
    public int getMAX_NUMERICAL() {
        return MAX_CONSUMMPTION;
    }

    @Override
    public int getMIN_NUMERICAL() {
        return MIN_CONSUMMPTION;
    }
}
