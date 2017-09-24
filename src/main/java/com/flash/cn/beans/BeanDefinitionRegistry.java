package com.flash.cn.beans;

import com.flash.cn.annotation.Autowired;
import com.flash.cn.annotation.Repository;
import com.flash.cn.core.ClassPathResource;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * Bean Definition 注册
 *
 * @author kay
 * @version v1.0
 */
public class BeanDefinitionRegistry implements BeanDefinition {

    /**
     * 反射生成新的对象
     *
     * @param name 反射对象的对象路径
     * @param <T>  弱类型转成指定强类型
     * @return 生成的新的对象
     * @throw BeanCreateFailureException 对象生成失败异常
     */
    @SuppressWarnings("unchecked")
    private <T> T newInstance(String name) {
        try {
            Class<T> clazz = (Class<T>) Class.forName(name);
            return clazz.newInstance();
        }
        catch (Exception e) {
            throw new BeanCreateFailureException(e);
        }
    }

    /**
     * 遍历 Class，载入 Repository 注释
     */
    private void loadRepository(Map<String, Object> container) {
        ClassPathResource resource = new ClassPathResource();
        List<Class<?>> list = resource.getClasses();
        for (Class clazz : list) {
            Repository annotation = (Repository) clazz.getAnnotation(Repository.class);
            if (annotation != null) {
                Object object = newInstance(clazz.getName());
                container.put(annotation.value(), object);
            }
        }
    }

    /**
     * 遍历容器，载入 Autowired 注释
     */
    private void loadAutowired(Map<String, Object> container) {
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
     * 注册 Bean.
     *
     * @param container 容器
     */
    @Override
    public void registry(Map<String, Object> container) {
        loadRepository(container);
        loadAutowired(container);
    }
}
