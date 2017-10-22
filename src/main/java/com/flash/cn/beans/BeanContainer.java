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
 * Bean 容器接口，定义Bean 容器的基本行为
 *
 * @author kay
 * @version v1.0
 */
public interface BeanContainer extends Map<String, Object> {

    /**
     * 根据关键字获取对象
     *
     * @param key 容器的关键字
     * @param <T> 强类型对象
     * @return 根据关键字获取对象
     */
    <T> T get(String key);

    /**
     * 根据关键字存放对象进入容器
     *
     * @param key    容器的关键字
     * @param object 放入容器的关键字
     * @return 放入容器的对象
     */
    Object put(String key, Object object);
}
