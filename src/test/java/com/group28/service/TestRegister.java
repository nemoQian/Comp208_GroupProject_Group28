package com.group28.service;

import org.junit.Test;

/**
 * The type Test register.
 *
 * @author Yucheng Du
 * @version 1.0
 */
public class TestRegister {
    /**
     * Test register.
     */
    @Test
    public void testRegister(){
        UserServiceImpl service = new UserServiceImpl();

        System.out.println(service.Register("Kamisato_Ayaka", "Inazuma001", "Ayaka@Tri.com"));
        System.out.println(service.Register("", "", ""));
        System.out.println(service.Register(null, null, null));
        System.out.println(service.Register("Kamisato_Ayaka", "", ""));
        System.out.println(service.Register("", "", "Ayaka@Tri.com"));
        System.out.println(service.Register("", "Inazuma001", ""));
        System.out.println(service.Register("Kamisato_Ayaka", null, null));
        System.out.println(service.Register(null, null, "Ayaka@Tri.com"));
        System.out.println(service.Register(null, "Inazuma001", null));
        System.out.println(service.Register("YuyuanCao", "G52828", "Yuyuan.Cao19@xjtlu.edu.cn"));
        System.out.println(service.login("YuyuanCao", "G52828"));

    }
}
