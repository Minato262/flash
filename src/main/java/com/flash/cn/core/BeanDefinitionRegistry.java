package com.flash.cn.core;

import com.flash.cn.beans.BeanCreateFailureException;

/**
 * @author kay
 * @version v1.0
 */
public class BeanDefinitionRegistry {

    @SuppressWarnings("unchecked")
    public <T> T registryBean(String name) {
        try {
            Class<T> clazz = (Class<T>) Class.forName(name);
            return clazz.newInstance();
        }
        catch (Exception e) {
            throw new BeanCreateFailureException(e);
        }
    }
}
