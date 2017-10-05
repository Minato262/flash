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

import com.flash.cn.util.ContainerMode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bean 核心容器
 *
 * @author kay
 * @version v1.0
 */
public final class BeanContainer {

    /** 容器模式（根据配置选择单例或者多例模式） */
    private static final ContainerMode CONTAINER_MODES = ContainerMode.getContainerModes();

    /** Bean 容器中的 map，Bean 资源主要存放在这个 map 中 */
    private static Map<String, Object> container = new ConcurrentHashMap<String, Object>();

    /** Bean 容器的静态对象，单例模式下使用 */
    private static BeanContainer instance = new BeanContainer();

    /** Bean Definition 注册 */
    private BeanDefinition registry = new BeanDefinitionRegistry();

    /**
     * 获取 Bean 核心容器对象，单例模式下获取的是静态对象，多例模式下新建对象
     *
     * @return Bean 容器对象
     */
    public static synchronized BeanContainer getInstance() {
        return CONTAINER_MODES.isSingleton() ? instance : new BeanContainer();
    }

    /**
     * 默认构造器
     */
    private BeanContainer() {
        if (container.isEmpty()) {
            registry.registry(container);       // 注册容器中的 Bean 对象
        }
    }

    /**
     * 根据 key 获取容器中的对象
     *
     * @param key 容器关键字
     * @param <T> 弱类型转换成强类型
     * @return 返回容器中的对象
     */
    @SuppressWarnings("unchecked")
    public <T> T getValue(String key) {
        if (CONTAINER_MODES.isSingleton()) {
            registry.registry(container, key);
        }
        return (T) container.get(key);
    }
}
