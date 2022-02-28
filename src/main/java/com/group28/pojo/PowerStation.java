package com.group28.pojo;

/**
 * The type Power station extends Facility.
 *
 * @author Yihan Qian
 */
public class PowerStation extends Facility{

    private ZipCode zipCode;
    private PowerStationType powerStationType;
    private int powerStationId;
    private String powerStationName;

    /**
     * Instantiates a new Power station.
     *
     * @param zipCode          the zip code
     * @param powerStationType the power station type
     * @param powerStationId   the power station id
     * @param powerStationName the power station name
     */
    public PowerStation(ZipCode zipCode, PowerStationType powerStationType,
                        int powerStationId, String powerStationName) {
        super(zipCode, powerStationType, powerStationId, powerStationName);
    }

    /**
     * Gets zip code.
     *
     * @return the zip code
     */
    @Override
    public ZipCode getZipCode() {
        return zipCode;
    }

    /**
     * Gets power station type.
     *
     * @return the power station type
     */
    public PowerStationType getPowerStationType() {
        return powerStationType;
    }

    /**
     * Gets power station id.
     *
     * @return the power station id
     */
    public int getPowerStationId() {
        return powerStationId;
    }

    /**
     * Gets power station name.
     *
     * @return the power station name
     */
    public String getPowerStationName() {
        return powerStationName;
    }

    @Override
    public String toString() {
        return "PowerStation{" +
                "zipCode=" + zipCode +
                ", powerStationType=" + powerStationType +
                ", powerStationId=" + powerStationId +
                ", powerStationName='" + powerStationName + '\'' +
                '}';
    }
}
