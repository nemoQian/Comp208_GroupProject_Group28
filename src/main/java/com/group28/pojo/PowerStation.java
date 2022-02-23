package com.group28.pojo;

/**
 * The type Power station.
 *
 * @author Yihan Qian
 */
public class PowerStation {
    private ZipCode zipCode;
    private int electricityUnitId;
    private PowerStationType powerStationType;
    private String electricityUnitName;

    /**
     * Instantiates a new Power station.
     */
    public PowerStation() {
    }

    /**
     * Instantiates a new Power station.
     *
     * @param zipCode             the zip code
     * @param electricityUnitId   the electricity unit id
     * @param powerStationType    the power station type
     * @param electricityUnitName the electricity unit name
     */
    public PowerStation(ZipCode zipCode, int electricityUnitId,
                        PowerStationType powerStationType, String electricityUnitName) {
        this.zipCode = zipCode;
        this.electricityUnitId = electricityUnitId;
        this.powerStationType = powerStationType;
        this.electricityUnitName = electricityUnitName;
    }

    /**
     * Gets zip code.
     *
     * @return the zip code
     */
    public ZipCode getZipCode() {
        return zipCode;
    }

    /**
     * Sets zip code.
     *
     * @param zipCode the zip code
     */
    public void setZipCode(ZipCode zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets electricity unit id.
     *
     * @return the electricity unit id
     */
    public int getElectricityUnitId() {
        return electricityUnitId;
    }

    /**
     * Sets electricity unit id.
     *
     * @param electricityUnitId the electricity unit id
     */
    public void setElectricityUnitId(int electricityUnitId) {
        this.electricityUnitId = electricityUnitId;
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
     * Sets power station type.
     *
     * @param powerStationType the power station type
     */
    public void setPowerStationType(PowerStationType powerStationType) {
        this.powerStationType = powerStationType;
    }

    /**
     * Gets electricity unit name.
     *
     * @return the electricity unit name
     */
    public String getElectricityUnitName() {
        return electricityUnitName;
    }

    /**
     * Sets electricity unit name.
     *
     * @param electricityUnitName the electricity unit name
     */
    public void setElectricityUnitName(String electricityUnitName) {
        this.electricityUnitName = electricityUnitName;
    }

    @Override
    public String toString() {
        return "PowerStation{" +
                "zipCode=" + zipCode +
                ", electricityUnitId=" + electricityUnitId +
                ", powerStationType=" + powerStationType +
                ", electricityUnitName='" + electricityUnitName + '\'' +
                '}';
    }
}
