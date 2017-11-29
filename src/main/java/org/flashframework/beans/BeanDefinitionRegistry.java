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
package org.flashframework.beans;

import org.flashframework.annotation.Scope;
import org.flashframework.util.Assert;

import java.util.Map;

/**
 * Bean Definition 注册
 *
 * @author kay
 * @version v1.0
 */
public class BeanDefinitionRegistry implements Registry {

    /** Bean 容器 */
    private BeanContainer container = BeanContainerAware.getInstance();

    /** Bean Definition 解析接口 */
    private Resolution resolution;

    /**
     * 带有 Bean Definition 注册的构造器
     *
     * @param resolution Bean Definition 解析
     * @throws IllegalArgumentException 如果字符串为null
     */
    public BeanDefinitionRegistry(Resolution resolution) {
        Assert.isNotNull(resolution);
        this.resolution = resolution;
    }

    /**
     * 单例或者原型模式，载入类注解
     *
     * @param registryTable 需要注入的注册对象信息
     */
    private <V> void loadRepository(BeanDefinitionTable registryTable) {
        for (Map.Entry<String, Class> entry : registryTable.entrySet()) {
            Scope scope = (Scope) entry.getValue().getAnnotation(Scope.class);
            if (scope != null && BeanContainerMode.PROTOTYPE.equals(scope.value())) {
                // scope 注解标记的多例，在初始化时，引入对象的 class 信息作为标记
                container.put(entry.getKey(), entry.getValue());
                continue;
            }
            V value = BeanReflect.newInstance(entry.getValue().getName());
            container.put(entry.getKey(), value);
        }
    }

    /**
     * 根据容器中的 key 注入对象，载入方法注释
     *
     * @param registryTable 需要注入的注册对象信息
     * @throws BeanCreateFailureException Bean 设置失败
     */
    private void loadAutowired(BeanDefinitionTable registryTable) {
        BeanReflectAutowired autowired = new BeanReflectAutowired();
        for (Map.Entry<String, Class> entry : registryTable.entrySet()) {
            BeanDefinitionWrap wrap = autowired.loadAutowired(entry.getKey());
            if (wrap.isHasAutowired()) {
                container.put(entry.getKey(), wrap.getData());
            }
        }
    }

    /**
     * 默认注册 Bean，注解标记的 bean 默认为单例模式，容器初始化时会一次性载入所
     * 有 Bean
     *
     * @throws BeanDefinitionConflictException 如果 Bean 对象已经存在
     */
    @Override
    public void refresh() {
        // 注册表载入
        resolution.load();

        // 载入类和方法注解
        BeanDefinitionTable table = BeanDefinitionTableAware.getInstance();
        loadRepository(table);
        loadAutowired(table);
    }
}
