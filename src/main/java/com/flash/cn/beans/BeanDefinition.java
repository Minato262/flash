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
     * 注册 Bean.
     *
     * @param container 容器
     * @throw BeanCreateFailureException Bean 初始化加载异常
     */
    void registry(Map<String, Object> container);
}
