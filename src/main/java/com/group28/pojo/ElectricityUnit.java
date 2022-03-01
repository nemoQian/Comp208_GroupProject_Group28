package com.group28.pojo;

/**
 * The type Electricity unit extends Facility.
 *
 * @author Yihan Qian
 * @version 1.0
 */
public class ElectricityUnit extends Facility{

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
        super(zipCode, electricityUnitType, electricityUnitId, electricityUnitName);
    }

    @Override
    public ZipCode getZipCode() {
        return zipCode;
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
     * Gets electricity unit id.
     *
     * @return the electricity unit id
     */
    public int getElectricityUnitId() {
        return electricityUnitId;
    }

    /**
     * Gets electricity unit name.
     *
     * @return the electricity unit name
     */
    public String getElectricityUnitName() {
        return electricityUnitName;
    }
}
