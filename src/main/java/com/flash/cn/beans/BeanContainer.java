package com.flash.cn.beans;

import com.flash.cn.util.ContainerMode;
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
     * 是否是单例模式
     */
    private static final ContainerMode CONTAINER_MODES = new LoadProperties().getContainerModes();

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
        return CONTAINER_MODES.isSingleton() ? instance : new BeanContainer();
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
     * 根据 key 获取容器中的对象的相对路径，然后根据相对路径反射生成新的对象
     *
     * @param key 容器关键字
     * @param <T> 弱类型转换成强类型
     * @return 返回容器中的对象
     */
    private <T> T newInstance(String key) {
        String objectPath = container.get(key).getClass().getName();
        return BeanReflect.newInstance(objectPath);
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
        return CONTAINER_MODES.isSingleton() ? (T) container.get(key) : (T) newInstance(key);
    }
}
