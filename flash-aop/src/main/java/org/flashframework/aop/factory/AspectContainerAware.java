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
package org.flashframework.aop.factory;

import org.flashframework.beans.BeanNotFindException;
import org.flashframework.beans.container.BeanContainerAware;
import org.flashframework.core.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kay
 * @version v2.0
 */
public final class AspectContainerAware extends ConcurrentHashMap implements AspectContainer {
    private static final long serialVersionUID = -5199907673664115807L;

    private static final Logger log = LoggerFactory.getLogger(BeanContainerAware.class);

    /*
     * 概述:
     *
     *      容器是用于管理对象的生命周期的。
     *
     *      在框架中，定义了对象的名称，如何产生对象（单例模式或者原型模式），对象与对象之间
     * 的关系，使用容器来存储她们，是一种直接有效的方式。当容器启动后，所有的对象都可以直接取
     * 用，不需要进行硬编码，也不需要重新确立对象与对象之间的关系。
     */

    /**
     * Bean 容器的静态对象，用于存储有注解的类的相关信息
     */
    private static final AspectContainer container = new AspectContainerAware();

    public static final String ASPECT = "aspect";

    /**
     * 获取 Bean 核心容器对象，单例模式下获取的是静态对象，原型模式下新建对象
     *
     * @return Bean 容器接口
     */
    public static AspectContainer getInstance() {
        return container;
    }

    private AspectContainerAware() {
        //
    }

    @Override
    public Object get(String key) {
        return null;
    }

    /**
     * 根据关键字存放对象进入容器
     *
     * @param key   容器的关键字
     * @param value 放入容器的关键字
     * @throws BeanNotFindException 如果 Bean 的名称为空
     */
    @SuppressWarnings("unchecked")
    @Override
    public <V> void put(String key, V value) {
        if (StringUtils.isEmpty(key)) {
            throw new BeanNotFindException("The key of bean must be not empty!");
        }

        if (log.isDebugEnabled()) {
            log.debug("Aspect Container put, key:{}, value:{}", key, value);
        }
        super.put(key, value);
    }
}
