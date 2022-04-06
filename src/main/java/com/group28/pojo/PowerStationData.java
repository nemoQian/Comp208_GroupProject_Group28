package com.group28.pojo;

/**
 * The type Power station data.
 *
 * @author Yihan Qian
 * @version 1.0
 */
public class PowerStationData {

    private String DATA_REFERENCE_ID;
    private String powerStationId;
    private String timeOfStore;
    private int productivityAmount;

    public String getDATA_REFERENCE_ID() {
        return DATA_REFERENCE_ID;
    }

    public void setDATA_REFERENCE_ID(String DATA_REFERENCE_ID) {
        this.DATA_REFERENCE_ID = DATA_REFERENCE_ID;
    }

    public String getPowerStationId() {
        return powerStationId;
    }

    public void setPowerStationId(String powerStationId) {
        this.powerStationId = powerStationId;
    }

    public String getTimeOfStore() {
        return timeOfStore;
    }

    public void setTimeOfStore(String timeOfStore) {
        this.timeOfStore = timeOfStore;
    }

    public int getProductivityAmount() {
        return productivityAmount;
    }

    public void setProductivityAmount(int productivityAmount) {
        this.productivityAmount = productivityAmount;
    }

    @Override
    public String toString() {
        return "PowerStationData{" +
                "DATA_REFERENCE_ID='" + DATA_REFERENCE_ID + '\'' +
                ", powerStationId='" + powerStationId + '\'' +
                ", timeOfStore='" + timeOfStore + '\'' +
                ", productivityAmount=" + productivityAmount +
                '}';
    }
}
