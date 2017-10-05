package com.flash.cn.beans;

import java.util.Map;

/**
 * Bean Definition 接口
 *
 * @author kay
 * @version v1.0
 */
public interface BeanDefinition {

    /**
     * 默认注册 Bean，注解标记的 bean 默认为单例模式，容器初始化时会一次性载入所有对象
     *
     * @param container 需要注册的容器
     * @throw BeanCreateFailureException Bean 初始化加载异常
     */
    void registry(Map<String, Object> container);

    /**
     * 多例模式下注册 Bean，每次获取容器中 bean，会重新载入相应对象
     *
     * @param container 需要注册的容器
     * @param key       容器中的关键字
     * @throw BeanCreateFailureException Bean 初始化加载异常
     */
    void registry(Map<String, Object> container, String key);
}
