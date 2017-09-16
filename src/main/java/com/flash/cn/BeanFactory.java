package com.flash.cn;

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
     * @param name the required of type
     * @param <T>  new object
     * @return bean object
     */
    <T> T getBean(String name);
}
