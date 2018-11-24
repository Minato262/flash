/*
 * Copyright 2017-2018 the original author or authors.
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
package org.flashframework.beans.factory;

import org.flashframework.beans.BeanCreateFailureException;
import org.flashframework.beans.annotation.Autowired;
import org.flashframework.beans.container.BeanContainer;
import org.flashframework.beans.container.BeanContainerAware;
import org.flashframework.beans.util.BeanUtils;
import org.flashframework.core.util.Assert;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 自动反射扫描工具类
 *
 * @author kay
 * @version v1.0
 */
public final class BeanDefinitionWrapImpl {

    /** Bean 容器 */
    private BeanContainer container = BeanContainerAware.getInstance();

    /**
     * 根据实例信息，载入方法注解
     *
     * @param clazz 实例信息（一定不能为null）
     * @return Bean 对应并载入方法注解的对象
     * @throws IllegalArgumentException   如果对象为null
     * @throws BeanCreateFailureException 如果 Bean 创建失败
     */
    public <V> V loadBeanDefinition(Class clazz) {
        Assert.isNotNull(clazz);
        V newValue = BeanUtils.newInstance(clazz);
        return loadBeanDefinition(newValue);
    }

    /**
     * 根据容器 key，载入方法注解
     *
     * @param key 容器 key（一定不能为空）
     * @return Bean 对应并载入方法注解的对象
     * @throws IllegalArgumentException   如果字符串为空
     * @throws BeanCreateFailureException 如果 Bean 创建失败
     */
    public BeanDefinitionWrap load(String key) {
        Assert.isNotEmpty(key);
        Object value = container.get(key);
        if (value != null) {
            return load(value);
        }
        else {
            return new BeanDefinitionWrap();
        }
    }

    /**
     * 根据检测的对象，载入 {@code Autowired} 和 {@code Resource} 方法注解
     *
     * @param value 需要检测的对象
     * @return Bean Definition 的封装类
     * @throws BeanCreateFailureException 如果 Bean 创建失败
     */
    private <V> BeanDefinitionWrap<V> load(V value) {
        // 判断 BeanDefinition 是否需要载入
        boolean isInject = false;
        for (Field field : value.getClass().getDeclaredFields()) {
            for (Annotation annotation : field.getAnnotations()) {
                if (annotation instanceof Autowired || annotation instanceof Resource) {
                    try {
                        field.setAccessible(true);

                        // 根据 key 获取容器对应信息，如果为Class，则返回对象
                        Object object = container.get(field.getName());
                        if (object instanceof Class) {
                            object = loadBeanDefinition(object.getClass());
                        }

                        field.set(value, object);
                        isInject = true;
                        break;
                    }
                    catch (IllegalAccessException e) {
                        throw new BeanLoadFailureException(e);
                    }
                }
            }
        }
        return new BeanDefinitionWrap<>(isInject, value);
    }

    /**
     * 将空对象载入 Bean Definition
     *
     * @param value 需要载入注解的对象
     * @param <V> value
     * @return 载入的对象
     */
    private <V> V loadBeanDefinition(V value) {
        BeanDefinitionWrap<V> beanDefinitionWrap = load(value);
        return beanDefinitionWrap.getData();
    }
}