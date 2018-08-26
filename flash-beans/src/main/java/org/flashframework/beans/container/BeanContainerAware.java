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

import org.flashframework.Aware;
import org.flashframework.util.Assert;
import org.flashframework.util.StringUtils;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Bean 核心容器辅助类，单例模式。
 *
 * @author kay
 * @version v1.0
 */
public final class BeanContainerAware extends ConcurrentHashMap implements BeanContainer, Aware {

    /*
     * 概况
     * 容器是用于管理对象的生命周期的。在框架中，定义了对象的名称，如何产生对象（单例模式或者
     * 原型模式），对象与对象之间的关系，使用容器来存储她们，是一种直接有效的方式。当容器启动
     * 后，所有的对象都可以直接取用，不需要进行硬编码，也不需要重新确立对象与对象之间的关系。
     */

    /* ------------------------------  静态区  ------------------------------- */

    /**
     * Bean 容器的静态对象，用于存储有注解的类的相关信息
     */
    private static BeanContainer container = new BeanContainerAware();

    /**
     * 获取 Bean 核心容器对象，单例模式下获取的是静态对象，原型模式下新建对象
     *
     * @return Bean 容器接口
     */
    public static BeanContainer getInstance() {
        return container;
    }

    /* ------------------------------  构造区  ------------------------------- */

    /**
     * 默认构造器
     */
    private BeanContainerAware() {
        //
    }

    /* ------------------------------  方法区  ------------------------------- */

    /**
     * 根据 key 获取容器中的对象
     *
     * @param key 容器关键字(一定不能为空)
     * @return 返回容器中的对象
     * @throws IllegalArgumentException 如果字符串为空
     */
    @Override
    public Object get(String key) {
        Assert.isNotEmpty(key);
        return super.get(key);
    }

    /**
     * 根据关键字存放对象进入容器
     *
     * @param key   容器的关键字
     * @param value 放入容器的关键字
     * @throws BeanContainerInitFailureException 如果 Bean 的名称为空
     */
    @SuppressWarnings("unchecked")
    @Override
    public <V> void put(String key, V value) {
        if (StringUtils.isEmpty(key)) {
            throw new BeanContainerInitFailureException("The key of bean must be not empty!");
        }
        super.put(key, value);
    }
}
