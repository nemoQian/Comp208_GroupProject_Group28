package com.group28.pojo;

/**
 * The type Power station type extends FacilityType.
 *
 * @author Yihan Qian
 * @version 1.0
 */
public class PowerStationType extends FacilityType{

    private String type_Id;
    private Long MAX_PRODUCTION;

    /**
     * Instantiates a new Power station type.
     *
     * @param type_Id        the type id
     * @param MAX_PRODUCTION the max production
     */
    public PowerStationType(String type_Id, Long MAX_PRODUCTION) {
        super(type_Id,MAX_PRODUCTION);
    }

    /**
     * Gets type id.
     *
     * @return the type id
     */
    public String getTYPE_ID() {
        return type_Id;
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
                "TYPE_ID='" + type_Id + '\'' +
                ", MAX_PRODUCTION=" + MAX_PRODUCTION +
                '}';
    }
}
