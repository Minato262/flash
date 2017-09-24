package com.flash.cn.context;

import com.flash.cn.beans.BeanContainer;
import com.flash.cn.beans.BeanFactory;

/**
 * Application Context Factory.
 *
 * @author kay
 * @version v1.0
 */
public class ApplicationContextFactory implements BeanFactory {

    private BeanContainer container = BeanContainer.getInstance();

    public ApplicationContextFactory() {
        container.init();
    }

    /**
     * get Bean.
     *
     * @param name the required of type
     * @param <T>  new object
     * @return bean object
     * @throw BeanCreateFailureException
     */
    @Override
    public <T> T getBean(String name) {
        return container.getValue(name);
    }
}
