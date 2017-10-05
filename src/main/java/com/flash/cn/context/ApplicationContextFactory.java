package com.flash.cn.context;

import com.flash.cn.beans.BeanContainer;

/**
 * Application Context Factory.
 *
 * @author kay
 * @version v1.0
 */
public class ApplicationContextFactory implements ApplicationContext {

    /** Bean 容器 */
    private BeanContainer container = BeanContainer.getInstance();

    /**
     * 默认构造器
     */
    public ApplicationContextFactory() {
        //
    }

    /**
     * 获取 Bean
     *
     * @param name 想获取 Bean 的名称
     * @param <T>  获取容器中的 Bean 对象
     * @return bean 对象
     */
    @Override
    public <T> T getBean(String name) {
        return container.getValue(name);
    }
}
