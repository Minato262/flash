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
package org.flashframework.beans.handle;

import org.flashframework.beans.factory.BeanDefinitionTableContext;
import org.flashframework.core.util.StringUtils;

/**
 * 抽象拦截器，主要作用是用于拦截类中的注解
 *
 * @author kay
 * @version v2.0
 */
public abstract class AbstractHandle extends BeanDefinitionTableContext implements Handle {

    /**
     * 默认构造器
     */
    public AbstractHandle() {
        //
    }

    /**
     * 如果 没有设置名称，则自动获取类信息的名称
     *
     * @param clazz class 类信息
     * @return 简称
     */
    protected String getSimpleName(Class clazz) {
        return getSimpleName(null, clazz);
    }

    /**
     * 如果 没有设置名称，则自动获取类信息的名称
     *
     * @param value 设置的简称
     * @param clazz class 类信息
     * @return 简称
     */
    protected String getSimpleName(String value, Class clazz) {
        if (StringUtils.isEmpty(value)) {
            return StringUtils.toLowercaseFirst(clazz.getSimpleName());
        }
        else {
            return value;
        }
    }

    /**
     * 根据 Class，载入类注解信息
     *
     * @param clazz class 信息
     * @throws HandleRuntimeException 如果 Bean Definition 已经存在
     */
    @Override
    public void load(Class clazz) {
        throw new HandleRuntimeException();
    }
}
