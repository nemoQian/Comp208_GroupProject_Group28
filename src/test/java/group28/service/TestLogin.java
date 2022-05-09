package com.group28.service;

import org.junit.Test;


/**
 * The type Test login.
 *
 * @author Yuyuan Cao
 * @version 1.0
 */
public class TestLogin {
    /**
     * Test login.
     */
    @Test
    public void testLogin(){

        UserServiceImpl service = new UserServiceImpl();
        System.out.println(service.login("",""));
        System.out.println(service.login(null,null));
        System.out.println(service.login("Qyh","asd"));
        System.out.println(service.login("Qyh",""));
        System.out.println(service.login("Dyy","asd"));
        System.out.println(service.login("Ayh","G52828"));
        System.out.println(service.login("Qyh","G52828"));


    }
}
