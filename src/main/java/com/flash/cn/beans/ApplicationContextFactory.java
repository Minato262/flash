package com.flash.cn.beans;

/**
 * Application Context Factory.
 *
 * @author kay
 * @version v1.0
 */
public class ApplicationContextFactory extends BeanContainer implements BeanFactory {

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
