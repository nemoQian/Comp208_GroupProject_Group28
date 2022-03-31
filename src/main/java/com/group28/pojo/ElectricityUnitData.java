package com.group28.pojo;

/**
 * The type Electricity unit data.
 *
 * @author Yihan Qian
 * @version 1.0
 */
public class ElectricityUnitData {

    private final String DATA_REFERENCE_ID;
    private ElectricityUnit electricityUnit;
    private String timeOfStore;
    private int ConsumptionAmount;

    /**
     * Instantiates a new Electricity unit data.
     *
     * @param DATA_REFERENCE_ID the data reference id
     * @param electricityUnit   the electricity unit
     * @param timeOfStore       the time of store
     * @param consumptionAmount the consumption amount
     */
    public ElectricityUnitData(String DATA_REFERENCE_ID, ElectricityUnit electricityUnit,
                               String timeOfStore, int consumptionAmount) {
        this.DATA_REFERENCE_ID = DATA_REFERENCE_ID;
        this.electricityUnit = electricityUnit;
        this.timeOfStore = timeOfStore;
        ConsumptionAmount = consumptionAmount;
    }

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
    public ElectricityUnit getElectricityUnit() {
        return electricityUnit;
    }

    /**
     * Sets electricity unit.
     *
     * @param electricityUnit the electricity unit
     */
    public void setElectricityUnit(ElectricityUnit electricityUnit) {
        this.electricityUnit = electricityUnit;
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
                ", electricityUnit=" + electricityUnit +
                ", timeOfStore='" + timeOfStore + '\'' +
                ", ConsumptionAmount=" + ConsumptionAmount +
                '}';
    }
}
