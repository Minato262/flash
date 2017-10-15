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

import com.flash.cn.annotation.Scope;
import com.flash.cn.util.Assert;

import java.util.Map;

/**
 * Bean Definition 注册
 *
 * @author kay
 * @version v1.0
 */
public class BeanDefinitionRegistry implements BeanDefinition {

    private BeanContainer container;

    private BeanDefinitionTable table;

    /**
     * 带有 Bean Definition 注册的构造器
     *
     * @param table     Bean Definition 注册表（一定不能为null）
     * @param container Bean 容器（一定不能为null）
     */
    public BeanDefinitionRegistry(BeanDefinitionTable table, BeanContainer container) {
        Assert.isNotNull(table);
        Assert.isNotNull(container);
        this.table = table;
        this.container = container;
    }

    /**
     * 载入类注解
     *
     * @param registryTable 注册表
     */
    private void loadRepository(Map<String, Class> registryTable) {
        for (Map.Entry<String, Class> entry : registryTable.entrySet()) {
            Scope scope = (Scope) entry.getValue().getAnnotation(Scope.class);
            if (scope != null && BeanContainerMode.FLASH_PROPERTIES_PROTOTYPE.equals(scope.value())) {
                // scope 注解标记的实例，在初始化时，引入对象的 class 作为标记
                container.put(entry.getKey(), entry.getValue());
                continue;
            }
            Object object = BeanReflect.newInstance(entry.getValue().getName());
            container.put(entry.getKey(), object);
        }
    }

    /**
     * 根据容器中的key获取对象，载入方法注释
     *
     * @param registryTable 注册表
     * @throw BeanCreateFailureException Bean 设置失败
     */
    private void loadAutowired(Map<String, Class> registryTable) {
        for (Map.Entry<String, Class> entry : registryTable.entrySet()) {
            BeanDefinitionWrap wrap = BeanReflectAutowired.getInstance().loadAutowired(entry.getKey());
            if (wrap.isHasAutowired()) {
                container.put(entry.getKey(), wrap.getData());
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
        // 注册表刷新
        table.refresh();

        // 载入类和方法注解
        Map<String, Class> registryTable = table.getTable();
        loadRepository(registryTable);
        loadAutowired(registryTable);
    }
}
