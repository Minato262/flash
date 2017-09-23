package com.flash.cn.core;

import com.flash.cn.annotation.Autowired;
import com.flash.cn.annotation.Repository;
import com.flash.cn.util.PropertiesUtils;

import java.lang.reflect.Field;
import java.util.List;
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
     * 根据配置获取包名
     */
    private static final String FLASH_PACKAGE_NAME = PropertiesUtils.load("/config/flash.properties", "packageName");

    /**
     * 根据配置获取容器模式
     */
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

    /**
     * 默认构造器
     */
    private BeanContainer() {
        //
    }

    /**
     * 初始化容器
     */
    public void init() {
        loadRepository();
        loadAutowired();
    }
    
    private void loadRepository() {
        ClassPathResource resource = new ClassPathResource();
        List<Class<?>> list = resource.getClasses(FLASH_PACKAGE_NAME);
        for (Class clazz : list) {
            Repository annotation = (Repository) clazz.getAnnotation(Repository.class);
            if (annotation != null) {
                Object object = ClassUtils.newInstance(clazz.getName());
                container.put(annotation.value(), object);
            }
        }
    }

    private void loadAutowired() {
        for (Map.Entry<String, Object> entry : container.entrySet()) {
            boolean hasAutowired = false;
            Object object = container.get(entry.getKey());
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Autowired annotation = field.getAnnotation(Autowired.class);
                if (annotation != null) {
                    try {
                        field.set(object, container.get(field.getName()));
                    }
                    catch (IllegalAccessException e) {
                        throw new BeanCreateFailureException(e);
                    }
                    hasAutowired = true;
                }
            }
            if (hasAutowired) {
                container.put(entry.getKey(), object);
            }
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

    public void println() {
        for (Map.Entry<String, Object> entry : container.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("Size=" + container.size());
        }
    }
}
