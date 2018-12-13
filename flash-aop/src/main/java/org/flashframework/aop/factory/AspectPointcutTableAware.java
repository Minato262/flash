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

import org.flashframework.core.Aware;
import org.flashframework.core.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Aspect 切面注册表实现
 *
 * @author kay
 * @version v2.0
 */
public final class AspectPointcutTableAware extends ConcurrentHashMap implements AspectPointcutTable, Aware {
    private static final long serialVersionUID = -5199907673664115807L;

    private static final Logger log = LoggerFactory.getLogger(AspectPointcutTableAware.class);

    /**
     * Aspect 切面注册表的静态对象，用于存储有注解的类的相关信息
     */
    private static AspectPointcutTable table = new AspectPointcutTableAware();

    /**
     * 获取 Aspect 切面注册表，单例模式下获取的是静态对象，原型模式下新建对象
     *
     * @return Aspect 切面注册表
     */
    public static AspectPointcutTable getInstance() {
        return table;
    }

    /**
     * 默认构造器
     */
    private AspectPointcutTableAware() {
        //
    }

    /**
     * 根据关键字获取对象
     *
     * @param key 容器的关键字
     * @return 根据关键字获取对象
     * @throws AspectNotFindRuntimeException 如果 Bean 的名称为空
     */
    @Override
    public Object get(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new AspectNotFindRuntimeException("The key of bean must be not empty!");
        }
        return super.get(key);
    }

    /**
     * 根据关键字存放对象进入容器
     *
     * @param key   容器的关键字
     * @param value 放入容器的关键字
     * @throws AspectNotFindRuntimeException 如果 Bean 的名称为空
     */
    @SuppressWarnings("unchecked")
    @Override
    public <V> void put(String key, V value) {
        if (StringUtils.isEmpty(key)) {
            throw new AspectNotFindRuntimeException("The key of bean must be not empty!");
        }

        if (log.isDebugEnabled()) {
            log.debug("Aspect Pointcut table put, key:{}, value:{}", key, value);
        }
        super.put(key, value);
    }
}
