package com.flash.cn.core;

import com.flash.cn.annotation.Repository;
import com.flash.cn.util.PropertiesUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kay
 * @version v1.0
 */
public final class BeanContainer {

    private static final String FLASH_PACKAGE_NAME = PropertiesUtils.load("/config/flash.properties", "packageName");

    private static final String FLASH_CONTAINER = PropertiesUtils.load("/config/flash.properties", "containerModes");

    private static BeanContainer instance = new BeanContainer();

    public static synchronized BeanContainer getInstance() {
        if ("multiple".equals(FLASH_CONTAINER)) {
            return new BeanContainer();
        }
        else {
            return instance;
        }
    }

    private static Map<String, Object> container = new ConcurrentHashMap<String, Object>();

    private BeanContainer() {
    }

    public void init() {
        ClassPathResource resource = new ClassPathResource();
        List<Class<?>> list = resource.getClasses(FLASH_PACKAGE_NAME);

        BeanDefinitionRegistry beanDefinition = new BeanDefinitionRegistry();
        for (Class clazz : list) {
            Object object = beanDefinition.registryBean(clazz.getName());
            Repository annotation = (Repository) clazz.getAnnotation(Repository.class);
            container.put(annotation.value(), object);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T getValue(String key) {
        return (T) container.get(key);
    }

    public void println() {
        for (Map.Entry<String, Object> entry : container.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("Size=" + container.size());
        }
    }
}
