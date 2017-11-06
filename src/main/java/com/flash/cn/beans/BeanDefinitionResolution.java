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

import com.flash.cn.core.Resource;
import com.flash.cn.util.Assert;

import java.util.List;

/**
 * Bean Definition 解析
 *
 * @author kay
 * @version v1.0
 */
public class BeanDefinitionResolution extends BeanDefinitionTableContext implements Resolution {

    /** 资源解析接口 */
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
     * 遍历 Class，载入类注释并将对象放入容器的 value 中
     *
     * @throw BeanDefinitionConflictException 如果 Bean Definition 已经存在
     */
    private void loadRepository() {
        BeanDefinitionLoad load = new BeanDefinitionLoad();
        List<Class<?>> list = resource.getClasses();
        for (Class clazz : list) {
            load.load(clazz);
        }
    }

    /**
     * 默认注册 Bean，注解标记的 bean 默认为单例模式，容器初始化时会一次性载入所
     * 有 Bean
     *
     * @throw BeanDefinitionConflictException 如果 Bean 对象已经存在
     */
    @Override
    public void load() {
        clear();   // 初始化注册表
        loadRepository();   // 载入类注释
    }

    /**
     * 清理注册表
     */
    @Override
    public void clear() {
        super.clear();
    }
}
