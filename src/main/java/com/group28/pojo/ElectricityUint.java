package com.group28.pojo;

/**
 * The type Electricity uint.
 *
 * @author Yihan Qian
 */
public class ElectricityUint {
    private ZipCode zipCode;
    private int electricityUnitId;
    private ElectricityUnitType electricityUnitType;
    private String electricityUnitName;

    /**
     * Instantiates a new Electricity uint.
     */
    public ElectricityUint() {
    }

    /**
     * Instantiates a new Electricity uint.
     *
     * @param zipCode             the zip code
     * @param electricityUnitId   the electricity unit id
     * @param electricityUnitType the electricity unit type
     * @param electricityUnitName the electricity unit name
     */
    public ElectricityUint(ZipCode zipCode, int electricityUnitId,
                           ElectricityUnitType electricityUnitType, String electricityUnitName) {
        this.zipCode = zipCode;
        this.electricityUnitId = electricityUnitId;
        this.electricityUnitType = electricityUnitType;
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
        return "ElectricityUint{" +
                "zipCode=" + zipCode +
                ", electricityUnitId=" + electricityUnitId +
                ", electricityUnitType=" + electricityUnitType +
                ", electricityUnitName='" + electricityUnitName + '\'' +
                '}';
    }
}
