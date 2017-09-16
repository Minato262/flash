package com.flash.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * Application Context Factory.
 *
 * @author kay
 * @version v1.0
 */
public class ApplicationContextFactory implements BeanFactory {

    private Map<String, String> container = new HashMap<String, String>();

    /**
     * get Bean.
     *
     * @param name the required of type
     * @param <T>  new object
     * @return bean object
     * @throw BeanCreateFailureException
     */
    @SuppressWarnings("unchecked")
    @Override
    public <T> T getBean(String name) {
        try {
            Class<T> clazz = (Class<T>) Class.forName(name);
            return clazz.newInstance();
        }
        catch (Exception e) {
            throw new BeanCreateFailureException(e);
        }
    }
}
