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

import com.flash.cn.annotation.*;
import com.flash.cn.core.Resource;
import com.flash.cn.util.Assert;
import com.flash.cn.util.StringUtils;

import java.util.List;

/**
 * Bean Definition 解析
 *
 * @author kay
 * @version v1.0
 */
public class BeanDefinitionResolution implements Resolution {

    /** Bean Definition 注册表 */
    private BeanDefinitionMap registryTable = BeanDefinitionTableAware.getInstance().getTable();

    /** 资源解析相关 */
    private Resource resource;

    /**
     * 带有资源解析的 Bean Definition 解析的构造器
     *
     * @param resource 资源解析接口
     * @throw IllegalArgumentException 如果字符串为null
     */
    public BeanDefinitionResolution(Resource resource) {
        Assert.isNotNull(resource);
        this.resource = resource;
    }

    /**
     * 放入 Bean Definition 清单中
     *
     * @param key   注册表 key
     * @param clazz 注册对象内容
     * @throw BeanDefinitionConflictException 如果 Bean Definition 已经存在
     */
    private void put(String key, Class clazz) {
        if (StringUtils.isEmpty(key)) {
            // 类注解载入 Bean 容器，容器会自动载入类名作为 key
            // Bean 会作为 key 的关键字，会使用左驼峰命名
            String lowerCase = StringUtils.getLowerCase(clazz.getName());
            key = StringUtils.toLowerCaseFirstOne(lowerCase);
        }
        registryTable.put(key, clazz);
    }

    /**
     * 遍历 Class，载入类注释并将对象放入容器的 value 中
     *
     * @throw BeanDefinitionConflictException 如果 Bean Definition 已经存在
     */
    private void loadRepository() {
        List<Class<?>> list = resource.getClasses();
        for (Class clazz : list) {
            Repository annotation = (Repository) clazz.getAnnotation(Repository.class);
            if (annotation != null) {
                put(annotation.value(), clazz);
                continue;
            }
            Service annotation1 = (Service) clazz.getAnnotation(Service.class);
            if (annotation1 != null) {
                put(annotation1.value(), clazz);
                continue;
            }
            Controller annotation2 = (Controller) clazz.getAnnotation(Controller.class);
            if (annotation2 != null) {
                put("", clazz);
            }
        }
    }

    /**
     * 默认注册 Bean，注解标记的 bean 默认为单例模式，容器初始化时会一次性载入所
     * 有 Bean
     *
     * @throw BeanDefinitionConflictException 如果 Bean 对象已经存在
     */
    @Override
    public void refresh() {
        clear();   // 初始化注册表
        loadRepository();   // 载入类注释
    }

    /**
     * 清理注册表
     */
    @Override
    public void clear() {
        registryTable.clear();
    }
}
