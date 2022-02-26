package com.group28.pojo;

/**
 * The type Zip code.
 *
 * @author Yihan Qian
 */
public class ZipCode {

    private final String ZIP_CODE;
    private String block_Name;

    /**
     * Instantiates a new Zip code.
     *
     * @param ZIP_CODE   the zip code
     * @param block_Name the block name
     */
    public ZipCode(String ZIP_CODE, String block_Name) {
        this.ZIP_CODE = ZIP_CODE;
        this.block_Name = block_Name;
    }

    /**
     * Gets zip code.
     *
     * @return the zip code
     */
    public String getZIP_CODE() {
        return ZIP_CODE;
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
                "ZIP_CODE='" + ZIP_CODE + '\'' +
                ", block_Name='" + block_Name + '\'' +
                '}';
    }
}
