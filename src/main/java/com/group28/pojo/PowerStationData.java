package com.group28.pojo;

/**
 * The type Power station data.
 *
 * @author Yihan Qian
 * @version 1.0
 */
public class PowerStationData {

    private final String DATA_REFERENCE_ID;
    private String powerStationID;
    private String timeOfStore;
    private Long productivityAmount;

    /**
     * Instantiates a new Power station data.
     *
     * @param DATA_REFERENCE_ID  the data reference id
     * @param powerStationID       the power station
     * @param timeOfStore        the time of store
     * @param productivityAmount the productivity amount
     */
    public PowerStationData(String DATA_REFERENCE_ID, String powerStationID,
                            String timeOfStore, Long productivityAmount) {
        this.DATA_REFERENCE_ID = DATA_REFERENCE_ID;
        this.powerStationID = powerStationID;
        this.timeOfStore = timeOfStore;
        this.productivityAmount = productivityAmount;
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
     * Gets power station.
     *
     * @return the power station
     */
    public String getPowerStation() {
        return powerStationID;
    }

    /**
     * Sets power station.
     *
     * @param powerStationID the power station
     */
    public void setPowerStationID(String powerStationID) {
        this.powerStationID = powerStationID;
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
     * Gets productivity amount.
     *
     * @return the productivity amount
     */
    public Long getProductivityAmount() {
        return productivityAmount;
    }

    /**
     * Sets productivity amount.
     *
     * @param productivityAmount the productivity amount
     */
    public void setProductivityAmount(Long productivityAmount) {
        this.productivityAmount = productivityAmount;
    }

    @Override
    public String toString() {
        return "PowerStationData{" +
                "DATA_REFERENCE_ID='" + DATA_REFERENCE_ID + '\'' +
                ", powerStationID=" + powerStationID +
                ", timeOfStore='" + timeOfStore + '\'' +
                ", productivityAmount=" + productivityAmount +
                '}';
    }
}
