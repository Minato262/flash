package com.flash.cn.core.factory;

import com.flash.cn.annotation.Repository;

/**
 * {@link People} Test.
 *
 * @author kay
 * @version v0.0.1
 */
@Repository("2")
public class People extends Bean {

    public People(){
        this.setName("123");
        this.setAge(12);
    }
}
