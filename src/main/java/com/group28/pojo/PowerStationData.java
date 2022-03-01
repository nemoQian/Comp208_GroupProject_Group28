package com.group28.pojo;

/**
 * The type Power station data.
 *
 * @author Yihan Qian
 * @version 1.0
 */
public class PowerStationData {

    private final String DATA_REFERENCE_ID;
    private PowerStation powerStation;
    private String timeOfStore;
    private Long productivityAmount;

    /**
     * Instantiates a new Power station data.
     *
     * @param DATA_REFERENCE_ID  the data reference id
     * @param powerStation       the power station
     * @param timeOfStore        the time of store
     * @param productivityAmount the productivity amount
     */
    public PowerStationData(String DATA_REFERENCE_ID, PowerStation powerStation,
                            String timeOfStore, Long productivityAmount) {
        this.DATA_REFERENCE_ID = DATA_REFERENCE_ID;
        this.powerStation = powerStation;
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
    public PowerStation getPowerStation() {
        return powerStation;
    }

    /**
     * Sets power station.
     *
     * @param powerStation the power station
     */
    public void setPowerStation(PowerStation powerStation) {
        this.powerStation = powerStation;
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
                ", powerStation=" + powerStation +
                ", timeOfStore='" + timeOfStore + '\'' +
                ", productivityAmount=" + productivityAmount +
                '}';
    }
}
