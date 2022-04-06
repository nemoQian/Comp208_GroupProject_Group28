package com.group28.pojo;

/**
 * The type Electricity unit data.
 *
 * @author Yihan Qian
 * @version 1.0
 */
public class ElectricityUnitData {

    private String DATA_REFERENCE_ID;
    private String electricityUnitID;
    private String timeOfStore;
    private int ConsumptionAmount;

    /**
     * Instantiates a new Electricity unit data.
     *
     * @param DATA_REFERENCE_ID the data reference id
     * @param electricityUnitID   the electricity unit id
     * @param timeOfStore       the time of store
     * @param consumptionAmount the consumption amount
     */
//    public ElectricityUnitData(String DATA_REFERENCE_ID, String electricityUnitID,
//                               String timeOfStore, int consumptionAmount) {
//        this.DATA_REFERENCE_ID = DATA_REFERENCE_ID;
//        this.electricityUnitID = electricityUnitID;
//        this.timeOfStore = timeOfStore;
//        ConsumptionAmount = consumptionAmount;
//    }
//
//    public ElectricityUnitData() {
//    }

    /**
     * Gets data reference id.
     *
     * @return the data reference id
     */
    public String getDATA_REFERENCE_ID() {
        return DATA_REFERENCE_ID;
    }

    /**
     * Gets electricity unit.
     *
     * @return the electricity unit
     */
    public String getElectricityUnit() {
        return electricityUnitID;
    }

    /**
     * Sets electricity unit.
     *
     * @param electricityUnitId the electricity unit
     */
    public void setElectricityUnit(String electricityUnitId) {
        this.electricityUnitID = electricityUnitId;
    }

    /**
     * Gets time of store.
     *
     * @return the time of store
     */
    public String getTimeOfStore() {
        return timeOfStore;
    }

    /**
     * Sets time of store.
     *
     * @param timeOfStore the time of store
     */
    public void setTimeOfStore(String timeOfStore) {
        this.timeOfStore = timeOfStore;
    }

    /**
     * Gets consumption amount.
     *
     * @return the consumption amount
     */
    public int getConsumptionAmount() {
        return ConsumptionAmount;
    }

    /**
     * Sets consumption amount.
     *
     * @param consumptionAmount the consumption amount
     */
    public void setConsumptionAmount(int consumptionAmount) {
        ConsumptionAmount = consumptionAmount;
    }

    @Override
    public String toString() {
        return "ElectricityUnitData{" +
                "DATA_REFERENCE_ID='" + DATA_REFERENCE_ID + '\'' +
                ", electricityUnitId=" + electricityUnitID +
                ", timeOfStore='" + timeOfStore + '\'' +
                ", ConsumptionAmount=" + ConsumptionAmount +
                '}';
    }
}
