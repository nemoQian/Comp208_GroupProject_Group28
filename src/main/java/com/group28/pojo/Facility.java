package com.group28.pojo;

/**
 * The type Facility.
 *
 * @author Yihan Qian
 */
public class Facility {

    private ZipCode zipCode;
    private FacilityType facilityType;
    private int facilityId;
    private String facilityName;

    /**
     * Instantiates a new Facility.
     *
     * @param zipCode      the zip code
     * @param facilityType the facility type
     * @param facilityId   the facility id
     * @param facilityName the facility name
     */
    public Facility(ZipCode zipCode, FacilityType facilityType,
                    int facilityId, String facilityName) {
        this.zipCode = zipCode;
        this.facilityType = facilityType;
        this.facilityId = facilityId;
        this.facilityName = facilityName;
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
     * Gets facility type.
     *
     * @return the facility type
     */
    public FacilityType getFacilityType() {
        return facilityType;
    }

    /**
     * Gets facility id.
     *
     * @return the facility id
     */
    public int getFacilityId() {
        return facilityId;
    }

    /**
     * Gets facility name.
     *
     * @return the facility name
     */
    public String getFacilityName() {
        return facilityName;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "zipCode=" + zipCode +
                ", facilityType=" + facilityType +
                ", facilityId=" + facilityId +
                ", facilityName='" + facilityName + '\'' +
                '}';
    }
}
