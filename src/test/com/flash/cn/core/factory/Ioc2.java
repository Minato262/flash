package com.flash.cn.core.factory;

import com.flash.cn.annotation.Autowired;
import com.flash.cn.annotation.Controller;

/**
 * @author kay
 * @version v1.0
 */
@Controller("ioc2")
public class Ioc2 {

    @Autowired
    private Father father;

    @Autowired
    private People people;

    @Autowired
    private User user;

    @Autowired
    private Ioc1 ioc1;

    public Father getFather() {
        return father;
    }

    public People getPeople() {
        return people;
    }

    public User getUser() {
        return user;
    }

    public Ioc1 getIoc1() {
        return ioc1;
    }
}
