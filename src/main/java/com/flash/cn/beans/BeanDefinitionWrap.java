package com.flash.cn.beans;

/**
 * Bean Definition 包装类
 *
 * @author kay
 * @version v1.0
 */
public final class BeanDefinitionWrap {
    private boolean hasAutowired;
    private Object object;

    public BeanDefinitionWrap(boolean hasAutowired, Object object) {
        this.hasAutowired = hasAutowired;
        this.object = object;
    }

    public boolean isHasAutowired() {
        return hasAutowired;
    }

    public Object getObject() {
        return object;
    }

}
