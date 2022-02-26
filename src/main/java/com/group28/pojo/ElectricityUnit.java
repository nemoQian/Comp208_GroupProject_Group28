package com.group28.pojo;

/**
 * The type Electricity unit.
 *
 * @author Yihan Qian
 */
public class ElectricityUnit {

    private ZipCode zipCode;
    private ElectricityUnitType electricityUnitType;
    private int electricityUnitId;
    private String electricityUnitName;

    /**
     * Instantiates a new Electricity unit.
     *
     * @param zipCode             the zip code
     * @param electricityUnitType the electricity unit type
     * @param electricityUnitId   the electricity unit id
     * @param electricityUnitName the electricity unit name
     */
    public ElectricityUnit(ZipCode zipCode, ElectricityUnitType electricityUnitType,
                           int electricityUnitId, String electricityUnitName) {
        this.zipCode = zipCode;
        this.electricityUnitType = electricityUnitType;
        this.electricityUnitId = electricityUnitId;
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
     * Gets electricity unit type.
     *
     * @return the electricity unit type
     */
    public ElectricityUnitType getElectricityUnitType() {
        return electricityUnitType;
    }

    /**
     * Sets electricity unit type.
     *
     * @param electricityUnitType the electricity unit type
     */
    public void setElectricityUnitType(ElectricityUnitType electricityUnitType) {
        this.electricityUnitType = electricityUnitType;
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
        return "ElectricityUnit{" +
                "zipCode=" + zipCode +
                ", electricityUnitType=" + electricityUnitType +
                ", electricityUnitId=" + electricityUnitId +
                ", electricityUnitName='" + electricityUnitName + '\'' +
                '}';
    }

}
