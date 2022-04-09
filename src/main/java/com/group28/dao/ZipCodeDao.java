package com.group28.dao;

import com.group28.pojo.ZipCode;

import java.util.List;

/**
 * The interface Zip code mapper.
 *
 * @author Yihan Qian
 * @version 1.0
 */
public interface ZipCodeDao {

    /**
     * Gets zipCode list.
     *
     * @return the zipCode list
     */
    List<ZipCode> getZipCodeList();

    /**
     * Gets zip code.
     *
     * @param ZipCode the zipCode
     * @return the zipCode object
     */
    ZipCode getZipCode(String ZipCode);

    /**
     * Add zip code.
     *
     * @param zipCode the zipCode object
     */
    void addZipCode(ZipCode zipCode);

    List<String> getZipCode_CodeList();

    void DeleteZipCode(String zipCode);
}
