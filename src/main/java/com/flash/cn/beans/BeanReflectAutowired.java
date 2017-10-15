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
import com.flash.cn.util.Assert;

import java.lang.reflect.Field;

/**
 * 自动反射工作类
 *
 * @author kay
 * @version v1.0
 */
public final class BeanReflectAutowired {

    /** 静态自动反射工作类 */
    private static BeanReflectAutowired instance = new BeanReflectAutowired();

    /**
     * 获取 Bean 核心容器对象，单例模式下获取的是静态对象，原型模式下新建对象
     *
     * @return Bean 容器对象
     */
    public static BeanReflectAutowired getInstance() {
        synchronized (BeanReflectAutowired.class) {
            return instance;
        }
    }

    /**
     * 默认构造器
     */
    private BeanReflectAutowired(){
        //
    }

    /** Bean 容器 */
    private BeanContainer container = BeanContainer.getInstance();

    /**
     * 根据 key 获取容器对应信息，如果为对象，则返回对象，如果不是会重新新建对象
     *
     * @param key 容器 key
     * @return Bean 对应的对象
     */
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

    /**
     * 根据检测的对象，载入方法注解
     *
     * @param object 需要检测的对象
     * @return Bean Definition 的封装类
     */
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

    /**
     * 根据容器 key，载入方法注解
     *
     * @param key 容器 key
     * @return Bean 对应并载入方法注解的对象
     */
    public BeanDefinitionWrap<Object> loadAutowired(String key) {
        Assert.isNotEmpty(key);
        Object object = container.get(key);
        return loadAutowired(object);
    }

    /**
     * 根据实例信息，载入方法注解
     *
     * @param clazz 实例信息
     * @return Bean 对应并载入方法注解的对象
     */
    public Object loadAutowired(Class clazz) {
        Assert.isNotNull(clazz);
        Object object = BeanReflect.newInstance(clazz.getName());
        BeanDefinitionWrap<Object> beanDefinitionWrap = loadAutowired(object);
        return beanDefinitionWrap.getData();
    }
}
