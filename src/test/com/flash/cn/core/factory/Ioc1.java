package com.flash.cn.core.factory;

import com.flash.cn.annotation.Autowired;
import com.flash.cn.annotation.Service;

/**
 * @author kay
 * @version v1.0
 */
@Service("ioc1")
public class Ioc1 {

    @Autowired
    private Father father;

    @Autowired
    private People people;

    @Autowired
    private User user;

    @Autowired
    private Ioc ioc;

    public Father getFather() {
        return father;
    }

    public People getPeople() {
        return people;
    }

    public User getUser() {
        return user;
    }

    public Ioc getIoc() {
        return ioc;
    }
}
