package com.flash.cn.core;

import java.util.List;

/**
 * 获取资源相关接口
 *
 * @author kay
 * @version v1.0
 */
public interface Resource {

    /**
     * 获取所有当前包内 Class 类的集合类
     *
     * @return Class 类集合
     */
    List<Class<?>> getClasses();
}
