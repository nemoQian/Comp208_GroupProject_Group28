package com.group28.pojo;

/**
 * The type Zip code.
 *
 * @author Yihan Qian
 */
public class ZipCode {

    private String ZipCode;
    private String block_Name;

    /**
     * Instantiates a new Zip code.
     *
     * @param ZipCode   the zip code
     * @param block_Name the block name
     */
    public ZipCode(String ZipCode, String block_Name) {
        this.ZipCode = ZipCode;
        this.block_Name = block_Name;
    }

    /**
     * Gets zip code.
     *
     * @return the zip code
     */
    public String getZipCode() {
        return ZipCode;
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
                "ZIP_CODE='" + ZipCode + '\'' +
                ", block_Name='" + block_Name + '\'' +
                '}';
    }
}
