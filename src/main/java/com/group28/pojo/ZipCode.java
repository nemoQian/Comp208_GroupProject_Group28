package com.group28.pojo;

/**
 * The type Zip code.
 *
 * @author Yihan Qian
 */
public class ZipCode {
    private String zipCode;
    private String blockName;

    /**
     * Instantiates a new Zip code.
     */
    public ZipCode() {
    }

    /**
     * Instantiates a new Zip code.
     *
     * @param zipCode   the zip code
     * @param blockName the block name
     */
    public ZipCode(String zipCode, String blockName) {
        this.zipCode = zipCode;
        this.blockName = blockName;
    }

    /**
     * Gets zip code.
     *
     * @return the zip code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets zip code.
     *
     * @param zipCode the zip code
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets block name.
     *
     * @return the block name
     */
    public String getBlockName() {
        return blockName;
    }

    /**
     * Sets block name.
     *
     * @param blockName the block name
     */
    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    @Override
    public String toString() {
        return "ZipCode{" +
                "zipCode='" + zipCode + '\'' +
                ", blockName='" + blockName + '\'' +
                '}';
    }
}
