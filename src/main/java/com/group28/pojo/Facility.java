package com.group28.pojo;

/**
 * The type Facility.
 *
 * @author Yihan Qian
 * @version 1.1
 */
public class Facility {

    private String facilityId;
    private String facilityName;
    private ZipCode zipCode;
    private FacilityType facilityType;

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
    public String getFacilityId() {
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

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (facilityId == null ? 0 : facilityId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Facility facility = (Facility)obj;
        if (facility.getFacilityId() == this.facilityId){
            return true;
        }
        else {
            return false;
        }
    }
}
