package com.group28.pojo;

/**
 * The type Electricity unit type.
 *
 * @author Yihan Qian
 */
public class ElectricityUnitType {

    private final String TYPE_ID;
    private final Long MAX_CONSUMMPTION;
    private final Long MIN_CONSUMMPTION;

    /**
     * Instantiates a new Electricity unit type.
     *
     * @param TYPE_ID          the type id
     * @param MAX_CONSUMMPTION the max consummption
     * @param MIN_CONSUMMPTION the min consummption
     */
    public ElectricityUnitType(String TYPE_ID, Long MAX_CONSUMMPTION, Long MIN_CONSUMMPTION) {
        this.TYPE_ID = TYPE_ID;
        this.MAX_CONSUMMPTION = MAX_CONSUMMPTION;
        this.MIN_CONSUMMPTION = MIN_CONSUMMPTION;
    }

    /**
     * Gets type id.
     *
     * @return the type id
     */
    public String getTYPE_ID() {
        return TYPE_ID;
    }

    /**
     * Gets max consummption.
     *
     * @return the max consummption
     */
    public Long getMAX_CONSUMMPTION() {
        return MAX_CONSUMMPTION;
    }

    /**
     * Gets min consummption.
     *
     * @return the min consummption
     */
    public Long getMIN_CONSUMMPTION() {
        return MIN_CONSUMMPTION;
    }

    @Override
    public String toString() {
        return "ElectricityUnitType{" +
                "TYPE_ID='" + TYPE_ID + '\'' +
                ", MAX_CONSUMMPTION=" + MAX_CONSUMMPTION +
                ", MIN_CONSUMMPTION=" + MIN_CONSUMMPTION +
                '}';
    }
}
