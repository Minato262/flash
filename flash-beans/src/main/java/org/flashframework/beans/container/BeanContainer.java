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
package org.flashframework.beans.container;

import java.util.Map;

/**
 * Bean 容器接口，定义Bean 容器的基本行为
 * <p>这个接口继承于map 接口，在映射的基础上增加了常用的操作方法
 *
 * @author kay
 * @version v1.0
 */
public interface BeanContainer extends Map {

    /**
     * 根据关键字获取对象
     *
     * @param key 容器的关键字
     * @return 根据关键字获取对象
     */
    Object get(String key);

    /**
     * 根据容器的关键字放入对象
     *
     * @param key   容器的关键字
     * @param value 容器存入的对象
     */
    <V> void put(String key, V value);
}
