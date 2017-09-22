package com.flash.cn.beans;

import com.flash.cn.core.BeanContainer;
import com.flash.cn.util.PropertiesUtils;

/**
 * Application Context Factory.
 *
 * @author kay
 * @version v1.0
 */
public class ApplicationContextFactory implements BeanFactory {

    private BeanContainer container = BeanContainer.getInstance();

    public ApplicationContextFactory() {
        String packageName = PropertiesUtils.load("/config/flash.properties");
        container.init(packageName);
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
