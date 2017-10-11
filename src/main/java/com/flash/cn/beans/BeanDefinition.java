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

import java.util.Map;

/**
 * Bean Definition 接口
 *
 * @author kay
 * @version v1.0
 */
public interface BeanDefinition {

    /**
     * 注册 Bean，注解标记的 bean 默认为单例模式，容器初始化时会一次性载
     * 入所有 Bean
     *
     * @param container 需要注册的容器
     * @throw BeanCreateFailureException Bean 初始化加载异常
     */
    void registry(Map<String, Object> container);

    /**
     * 多例模式下注册 Bean，每次获取容器中 bean，会重新载入相应对象
     *
     * @param container 需要注册的容器
     * @param key       容器中的关键字
     * @throw BeanCreateFailureException Bean 初始化加载异常
     */
    void registry(Map<String, Object> container, String key);
}
