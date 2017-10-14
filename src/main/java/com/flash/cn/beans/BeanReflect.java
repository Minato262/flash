/*
 * Copyright 2017-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.flash.cn.beans;

import com.flash.cn.annotation.Autowired;

import java.lang.reflect.Field;

/**
 * 反射相关工具类
 *
 * @author kay
 * @version v1.0
 */
public class BeanReflect {

    private static BeanReflect instance = new BeanReflect();

    /**
     * 获取 Bean 核心容器对象，单例模式下获取的是静态对象，原型模式下新建对象
     *
     * @return Bean 容器对象
     */
    public static BeanReflect getInstance() {
        synchronized (BeanContainer.class) {
            return instance;
        }
    }

    /**
     * 根据对象的路径，反射生成新的对象
     *
     * @param name 反射对象的对象路径
     * @param <T>  弱类型转成指定强类型
     * @return 生成的新的对象
     * @throw BeanCreateFailureException 如果对象新建失败
     */
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

    /**
     * Bean 容器
     */
    private BeanContainer container = BeanContainer.getInstance();

    private Object getValue(String key) {
        Object object = container.get(key);
        if (object instanceof Class) {
            Class clazz = (Class) object;
            Object newObject = BeanReflect.newInstance(clazz.getName());
            BeanDefinitionWrap<Object> beanDefinitionWrap = loadAutowired(newObject);
            return beanDefinitionWrap.getData();
        }
        return container.get(key);
    }

    private BeanDefinitionWrap<Object> loadAutowired(Object object) {
        boolean hasAutowired = false;
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Autowired annotation = field.getAnnotation(Autowired.class);
            if (annotation != null) {
                try {
                    field.set(object, getValue(field.getName()));
                }
                catch (IllegalAccessException e) {
                    throw new BeanCreateFailureException(e);
                }
                hasAutowired = true;
            }
        }
        return new BeanDefinitionWrap<Object>(hasAutowired, object);
    }

    public BeanDefinitionWrap<Object> loadAutowired(String key) {
        Object object = container.get(key);
        return loadAutowired(object);
    }

    public Object loadAutowired(Class clazz) {
        Object object = BeanReflect.newInstance(clazz.getName());
        BeanDefinitionWrap<Object> beanDefinitionWrap = loadAutowired(object);
        return beanDefinitionWrap.getData();
    }
}
