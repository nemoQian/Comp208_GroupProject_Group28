package com.group28.pojo;

/**
 * The type Facility type.
 *
 * @author Yihan Qian
 */
public class FacilityType {

    private String type_Id;
    private Long MAX_NUMERICAL;
    private Long MIN_NUMERICAL;

    /**
     * Instantiates a new Facility type.
     *
     * @param type_Id       the type id
     * @param MAX_NUMERICAL the max numerical
     */
    public FacilityType(String type_Id, Long MAX_NUMERICAL) {
        this.type_Id = type_Id;
        this.MAX_NUMERICAL = MAX_NUMERICAL;
    }

    /**
     * Instantiates a new Facility type.
     *
     * @param type_Id       the type id
     * @param MAX_NUMERICAL the max numerical
     * @param MIN_NUMERICAL the min numerical
     */
    public FacilityType(String type_Id, Long MAX_NUMERICAL, Long MIN_NUMERICAL) {
        this.type_Id = type_Id;
        this.MAX_NUMERICAL = MAX_NUMERICAL;
        this.MIN_NUMERICAL = MIN_NUMERICAL;
    }

    /**
     * Gets type id.
     *
     * @return the type id
     */
    public String getType_Id() {
        return type_Id;
    }

    /**
     * Gets max numerical.
     *
     * @return the max numerical
     */
    public Long getMAX_NUMERICAL() {
        return MAX_NUMERICAL;
    }

    /**
     * Gets min numerical.
     *
     * @return the min numerical
     */
    public Long getMIN_NUMERICAL() {
        return MIN_NUMERICAL;
    }

}