package com.flash.cn.core;

import com.flash.cn.beans.BeanCreateFailureException;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * @author kay
 * @version v1.0
 */
public class ClassUtils {

    /**
     * 根据来源获取，目标 URL 资源
     *
     * @param name 资源名称
     * @return URL 元素资源
     * @throw ClassPathResourceException
     */
    public static Enumeration<URL> getEnumeration(String name) {
        try {
            return Thread.currentThread().getContextClassLoader().getResources(name);
        }
        catch (IOException e) {
            throw new ClassPathResourceException();
        }
    }

    /**
     * 载入 Class 类
     *
     * @param name 资源名称
     * @return 载入的 Class 类
     */
    public static Class<?> loadClass(String name) {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(name);
        }
        catch (ClassNotFoundException e) {
            throw new ClassPathResourceException();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T newInstance(String name) {
        try {
            Class<T> clazz = (Class<T>) Class.forName(name);
            return clazz.newInstance();
        }
        catch (Exception e) {
            throw new BeanCreateFailureException(e);
        }
    }
}
