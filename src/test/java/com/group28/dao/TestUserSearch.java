package com.group28.dao;

import com.group28.pojo.User;
import org.junit.Test;

/**
 * The type Test user search.
 *
 * @author Yuyuan Cao
 * @version 1.0
 */
public class TestUserSearch {
    /**
     * Test search.
     */
    @Test
    public void testSearch(){
        User user = new User();
        UserSearch userSearch =new UserSearch();
        user =userSearch.searchUser("Cyy");
        System.out.println(user);

    }

}
