package com.flash.cn.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Application Context Factory.
 *
 * @author kay
 * @version v1.0
 */
public class ApplicationContextFactory implements BeanFactory {

    private Map container = new HashMap();

    /**
     * get Bean.
     *
     * @param requiredType the required of type
     * @param <T>          new object
     * @return bean object
     */
    @Override
    public <T> T getBean(Class<T> requiredType) {
        return null;
    }
}
