package com.group28.pojo;

public class FacilityData {

    private final Facility facility;
    private final FacilityType facilityType;
    private final String facilityName;

    public FacilityData(Facility facility, FacilityType facilityType, String facilityName) {
        this.facility = facility;
        this.facilityType = facilityType;
        this.facilityName = facilityName;
    }

    public long getMaximum(){ return facilityType.getMAX_NUMERICAL(); }

    public double getConsumption(){
        return Math.random()*(facilityType.getMAX_NUMERICAL()-facilityType.getMIN_NUMERICAL())+facilityType.getMIN_NUMERICAL();
    }

    public Facility getFacility(){
        return facility;
    }

    public String getFacilityName() { return facilityName; }
}
