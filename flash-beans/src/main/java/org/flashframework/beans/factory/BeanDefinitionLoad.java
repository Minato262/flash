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
import org.flashframework.beans.util.BeanReflect;
import org.flashframework.core.util.Assert;

import javax.annotation.Resource;
import java.lang.reflect.Field;

/**
 * 自动反射扫描工具类
 *
 * @author kay
 * @version v1.0
 */
public final class BeanDefinitionLoad {

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
    public <V> V load(Class clazz) {
        Assert.isNotNull(clazz);
        V value = BeanReflect.newInstance(clazz.getName());
        BeanDefinitionWrap<V> beanDefinitionWrap = load(value);
        return beanDefinitionWrap.getData();
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
        return value != null ? load(value) : new BeanDefinitionWrap();
    }

    /**
     * 根据检测的对象，载入 {@code Autowired} 和 {@code Resource} 方法注解
     *
     * @param value 需要检测的对象
     * @return Bean Definition 的封装类
     * @throws BeanCreateFailureException 如果 Bean 创建失败
     */
    private <V> BeanDefinitionWrap<V> load(V value) {
        boolean isAutowired = false;
        Field[] fields = value.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Autowired annotation = field.getAnnotation(Autowired.class);
            if (annotation != null) {
                isAutowired = set(field, value);
            }
            // @Resource JSR-250 提供
            Resource annotation1 = field.getAnnotation(Resource.class);
            if (annotation1 != null) {
                isAutowired = set(field, value);
            }
        }
        return new BeanDefinitionWrap<>(isAutowired, value);
    }

    /**
     * 反射 设置作用域
     *
     * @param field 作用域
     * @param value 需要检测的对象值
     * @return 是否设置成功
     */
    private <V> boolean set(Field field, V value) {
        try {
            field.set(value, getValue(field.getName()));
            return true;
        }
        catch (IllegalAccessException e) {
            throw new BeanCreateFailureException(e);
        }
    }

    /**
     * 根据 key 获取容器对应信息，如果为对象，则返回对象，如果不是会重新新建对象
     *
     * @param key 容器的关键字
     * @return Bean 对应的对象
     */
    private Object getValue(String key) {
        Object value = container.get(key);
        if (value instanceof Class) {
            Class clazz = (Class) value;
            Object newValue = BeanReflect.newInstance(clazz.getName());

            // 重新载入方法注解
            BeanDefinitionWrap beanDefinitionWrap = load(newValue);
            return beanDefinitionWrap.getData();
        }
        else {
            return value;
        }
    }
}
