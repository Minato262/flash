package com.flash.cn.bean;

/**
 * Bean Factory.
 *
 * @author kay
 * @version v1.0
 */
public interface BeanFactory {

    /**
     * get Bean.
     *
     * @param requiredType the required of type
     * @param <T>          new object
     * @return bean object
     */
    <T> T getBean(Class<T> requiredType);
}
