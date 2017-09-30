package com.flash.cn.beans;

import com.flash.cn.util.LoadProperties;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bean 核心容器。
 *
 * @author kay
 * @version v1.0
 */
public final class BeanContainer {

    /**
     * 根据配置获取容器模式
     */
    private static final String FLASH_CONTAINER_MODE = LoadProperties.load("/config/flash.properties", "containerModes");

    /**
     * 容器模式————多例模式
     */
    private static final String CONTAINER_MODES_MULTIPLE = "multiple";

    /**
     * Bean 容器
     */
    private static Map<String, Object> container = new ConcurrentHashMap<String, Object>();

    /**
     * 默认构造器
     */
    private BeanContainer() {
        //
    }

    private static BeanContainer instance = new BeanContainer();

    public static synchronized BeanContainer getInstance() {
        if (CONTAINER_MODES_MULTIPLE.equals(FLASH_CONTAINER_MODE)) {
            return new BeanContainer();
        }
        else {
            return instance;    // 容器，如果没有配置，默认单例模式
        }
    }

    /**
     * 初始化容器
     */
    public void init() {
        if (container.size() == 0) {
            BeanDefinition registry = new BeanDefinitionRegistry();
            registry.registry(container);
        }
    }

    /**
     * 根据 key 获取容器中的对象
     *
     * @param key 容器关键字
     * @param <T> 弱类型转换成强类型
     * @return 返回容器中的对象
     */
    @SuppressWarnings("unchecked")
    public <T> T getValue(String key) {
        return (T) container.get(key);
    }
}
