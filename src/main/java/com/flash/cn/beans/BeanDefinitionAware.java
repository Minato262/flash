package com.flash.cn.beans;

/**
 * @author kay
 * @version v1.0
 */
public interface BeanDefinitionAware extends Aware {

    /**
     * 获取注册表
     *
     * @return 返回注册表
     */
    BeanDefinitionMap getTable();
}
