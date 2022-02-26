package com.group28.pojo;

/**
 * The type Power station type.
 *
 * @author Yihan Qian
 */
public class PowerStationType {

    private final String TYPE_ID;
    private final Long MAX_PRODUCTION;

    /**
     * Instantiates a new Power station type.
     *
     * @param TYPE_ID        the type id
     * @param MAX_PRODUCTION the max production
     */
    public PowerStationType(String TYPE_ID, Long MAX_PRODUCTION) {
        this.TYPE_ID = TYPE_ID;
        this.MAX_PRODUCTION = MAX_PRODUCTION;
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
     * Gets max production.
     *
     * @return the max production
     */
    public Long getMAX_PRODUCTION() {
        return MAX_PRODUCTION;
    }

    @Override
    public String toString() {
        return "PowerStationType{" +
                "TYPE_ID='" + TYPE_ID + '\'' +
                ", MAX_PRODUCTION=" + MAX_PRODUCTION +
                '}';
    }
}
