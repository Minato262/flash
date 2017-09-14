package com.flash.cn.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kay
 * @version v1.0
 */
public class ApplicationContextFactory implements BeanFactory {

    private Map beanContainer = new HashMap();

    @Override
    public void init() {

    }
}
