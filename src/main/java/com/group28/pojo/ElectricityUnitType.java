package com.group28.pojo;

/**
 * The type Electricity unit type extends FacilityType.
 *
 * @author Yihan Qian
 * @version 1.0
 */
public class ElectricityUnitType extends FacilityType{

    private String type_Id;
    private long MAX_CONSUMMPTION;
    private long MIN_CONSUMMPTION;

    /**
     * Instantiates a new Electricity unit type.
     *
     * @param type_Id          the type id
     * @param MAX_CONSUMMPTION the max consummption
     * @param MIN_CONSUMMPTION the min consummption
     */
    public ElectricityUnitType(String type_Id, Long MAX_CONSUMMPTION, Long MIN_CONSUMMPTION) {
        super(type_Id, MAX_CONSUMMPTION, MIN_CONSUMMPTION);
    }

    /**
     * Gets type id.
     *
     * @return the type id
     */
    public String gettype_Id() {
        return type_Id;
    }

    /**
     * Gets max consummption.
     *
     * @return the max consummption
     */
    public long getMAX_CONSUMMPTION() {
        return MAX_CONSUMMPTION;
    }

    /**
     * Gets min consummption.
     *
     * @return the min consummption
     */
    public long getMIN_CONSUMMPTION() {
        return MIN_CONSUMMPTION;
    }

    @Override
    public String toString() {
        return "ElectricityUnitType{" +
                "TYPE_ID='" + type_Id + '\'' +
                ", MAX_CONSUMMPTION=" + MAX_CONSUMMPTION +
                ", MIN_CONSUMMPTION=" + MIN_CONSUMMPTION +
                '}';
    }
}
