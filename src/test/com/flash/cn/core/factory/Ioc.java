package com.flash.cn.core.factory;

import com.flash.cn.annotation.Autowired;

/**
 * @author kay
 * @version v1.0
 */
public class Ioc {

    @Autowired
    private Father father;

    @Autowired
    private People people;

    @Autowired
    private User user;
}
