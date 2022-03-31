package com.group28.pojo;

/**
 * The type Zip code.
 *
 * @author Yihan Qian
 * @version 1.0
 */
public class ZipCode {

    private String zipCode;
    private String block_Name;

    /**
     * Instantiates a new Zip code.
     *
     * @param zipCode   the zip code
     * @param block_Name the block name
     */
    public ZipCode(String zipCode, String block_Name) {
        this.zipCode = zipCode;
        this.block_Name = block_Name;
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
     * Gets block name.
     *
     * @return the block name
     */
    public String getBlock_Name() {
        return block_Name;
    }

    /**
     * Sets block name.
     *
     * @param block_Name the block name
     */
    public void setBlock_Name(String block_Name) {
        this.block_Name = block_Name;
    }

    @Override
    public String toString() {
        return "ZipCode{" +
                "ZIP_CODE='" + zipCode + '\'' +
                ", block_Name='" + block_Name + '\'' +
                '}';
    }
}
