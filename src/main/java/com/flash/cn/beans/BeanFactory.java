package com.flash.cn.beans;

/**
 * Bean 工厂
 *
 * @author kay
 * @version v1.0
 */
public interface BeanFactory {

    /**
     * 获取 Bean
     *
     * @param name 想获取 Bean 的名称
     * @param <T>  获取容器中的 Bean 对象
     * @return bean 对象
     */
    <T> T getBean(String name);
}
