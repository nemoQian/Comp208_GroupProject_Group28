package com.group28.pojo;

/**
 * The type Electricity unit data.
 *
 * @author Yucheng Du
 * @version 1.0
 */
public class ElectricityUnitData {

    private String DATA_REFERENCE_ID;
    private String electricityUnitId;
    private String timeOfStore;
    private int ConsumptionAmount;

    @Override
    public String toString() {
        return "ElectricityUnitData{" +
                "DATA_REFERENCE_ID='" + DATA_REFERENCE_ID + '\'' +
                ", electricityUnitId='" + electricityUnitId + '\'' +
                ", timeOfStore='" + timeOfStore + '\'' +
                ", ConsumptionAmount=" + ConsumptionAmount +
                '}';
    }

    public void Put_DATA_REFERENCE_ID(String DATA_REFERENCE_ID){
        this.DATA_REFERENCE_ID = DATA_REFERENCE_ID;
    }

    public void Put_electricityUnitId(String electricityUnitId){
        this.electricityUnitId = electricityUnitId;
    }

    public void Put_timeOfStore(String timeOfStore){
        this.timeOfStore = timeOfStore;
    }

    public void Put_ConsumptionAmount(int ConsumptionAmount){
        this.ConsumptionAmount = ConsumptionAmount;
    }



    public String getDATA_REFERENCE_ID() {
        return DATA_REFERENCE_ID;
    }

    public void setDATA_REFERENCE_ID(String DATA_REFERENCE_ID) {
        this.DATA_REFERENCE_ID = DATA_REFERENCE_ID;
    }

    public String getElectricityUnitId() {
        return electricityUnitId;
    }


    public void setElectricityUnitId(String electricityUnitId) {
        this.electricityUnitId = electricityUnitId;
    }

    public String getTimeOfStore() {
        return timeOfStore;
    }

    public void setTimeOfStore(String timeOfStore) {
        this.timeOfStore = timeOfStore;
    }

    public int getConsumptionAmount() {
        return ConsumptionAmount;
    }

    public void setConsumptionAmount(int consumptionAmount) {
        ConsumptionAmount = consumptionAmount;
    }
}
