package com.group28.pojo;

/**
 * The type Power station type.
 *
 * @author Yihan Qian
 */
public class PowerStationType {

    private String powerStationType;
    private int MAX_PRODUCTION;

    /**
     * Instantiates a new Power station type.
     */
    public PowerStationType() {
    }

    /**
     * Instantiates a new Power station type.
     *
     * @param powerStationType the power station type
     * @param MAX_PRODUCTION   the max production
     */
    public PowerStationType(String powerStationType, int MAX_PRODUCTION) {
        this.powerStationType = powerStationType;
        this.MAX_PRODUCTION = MAX_PRODUCTION;
    }

    /**
     * Gets power station type.
     *
     * @return the power station type
     */
    public String getPowerStationType() {
        return powerStationType;
    }

    /**
     * Sets power station type.
     *
     * @param powerStationType the power station type
     */
    public void setPowerStationType(String powerStationType) {
        this.powerStationType = powerStationType;
    }

    /**
     * Gets max production.
     *
     * @return the max production
     */
    public int getMAX_PRODUCTION() {
        return MAX_PRODUCTION;
    }

    /**
     * Sets max production.
     *
     * @param MAX_PRODUCTION the max production
     */
    public void setMAX_PRODUCTION(int MAX_PRODUCTION) {
        this.MAX_PRODUCTION = MAX_PRODUCTION;
    }

    @Override
    public String toString() {
        return "PowerStationType{" +
                "powerStationType='" + powerStationType + '\'' +
                ", MAX_PRODUCTION=" + MAX_PRODUCTION +
                '}';
    }
}
