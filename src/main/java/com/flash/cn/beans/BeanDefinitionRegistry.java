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
import com.flash.cn.annotation.Controller;
import com.flash.cn.annotation.Repository;
import com.flash.cn.annotation.Service;
import com.flash.cn.core.ClassPathResource;
import com.flash.cn.util.Assert;
import com.flash.cn.util.StringUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * Bean Definition 注册
 *
 * @author kay
 * @version v1.0
 */
class BeanDefinitionRegistry implements BeanDefinition {

    /**
     * put 对象到容器中
     *
     * @param container 需要载入注册的容器
     * @param key       容器关键字
     * @param name      新建对象路径
     * @param isCheck   是否需要检测 bean 是否冲突
     * @throw BeanCreateFailureException 相应的 Bean 已经存在
     */
    private void put(Map<String, Object> container, String key, String name, boolean isCheck) {
        if (container.containsKey(key) && isCheck) {
            throw new BeanCreateFailureException("Bean 冲突，相应的 Bean 已经存在");
        }
        Object object = BeanReflect.newInstance(name);
        container.put(key, object);
    }

    /**
     * 遍历 Class，载入类注释
     *
     * @param container 需要注册的容器
     * @throw BeanCreateFailureException Bean 初始化加载异常
     */
    private void loadRepository(Map<String, Object> container) {
        ClassPathResource resource = new ClassPathResource();
        List<Class<?>> list = resource.getClasses();
        for (Class clazz : list) {
            Repository annotation = (Repository) clazz.getAnnotation(Repository.class);
            if (annotation != null) {
                put(container, annotation.value(), clazz.getName(), true);
                continue;
            }
            Service annotation1 = (Service) clazz.getAnnotation(Service.class);
            if (annotation1 != null) {
                put(container, annotation1.value(), clazz.getName(), true);
                continue;
            }
            Controller annotation2 = (Controller) clazz.getAnnotation(Controller.class);
            if (annotation2 != null) {
                String lowerCase = StringUtils.getLowerCase(clazz.getName());
                String lowerCaseFirstOne = StringUtils.toLowerCaseFirstOne(lowerCase);
                put(container, lowerCaseFirstOne, clazz.getName(), true);
            }
        }
    }

    /**
     * 根据容器中的key，载入方法注释
     *
     * @param container 需要注册的容器
     * @param key       容器中的key
     * @throw BeanCreateFailureException Bean 设置失败
     */
    private BeanDefinitionWrap loadAutowired(Map<String, Object> container, String key) {
        boolean hasAutowired = false;
        Object object = container.get(key);
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
        return new BeanDefinitionWrap(hasAutowired, object);
    }

    /**
     * 遍历容器，载入方法注释
     *
     * @param container 需要遍历载入的容器
     * @throw BeanCreateFailureException Bean 设置失败
     */
    private void loadAutowired(Map<String, Object> container) {
        for (Map.Entry<String, Object> entry : container.entrySet()) {
            BeanDefinitionWrap warp = loadAutowired(container, entry.getKey());
            if (warp.isHasAutowired()) {
                container.put(entry.getKey(), warp.getObject());
            }
        }
    }

    /**
     * 默认注册 Bean，注解标记的 bean 默认为单例模式，容器初始化时会一次性载入所有对象
     *
     * @param container 需要注册的容器
     * @throw BeanCreateFailureException Bean 初始化加载异常
     */
    @Override
    public void registry(Map<String, Object> container) {
        loadRepository(container);
        loadAutowired(container);
    }

    /**
     * 多例模式下注册 Bean，每次获取容器中 bean，会重新载入相应对象
     *
     * @param container 需要注册的容器
     * @param key       容器中的关键字
     * @throw BeanCreateFailureException Bean 初始化加载异常
     */
    @Override
    public void registry(Map<String, Object> container, String key) {
        String name = container.get(key).getClass().getName();
        Assert.isNotEmpty(name);
        put(container, key, name, false);
        loadAutowired(container, key);
    }
}
