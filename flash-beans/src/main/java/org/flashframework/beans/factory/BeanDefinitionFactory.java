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
package org.flashframework.beans.factory;

/**
 * Bean Definition 载入
 *
 * @author kay
 * @version v1.0
 */
public interface BeanDefinitionFactory {

    /**
     * 根据 Class，载入类注解信息
     *
     * @param clazz class 信息
     * @throws IllegalArgumentException        如果字符串为null
     * @throws BeanDefinitionConflictException 如果 Bean Definition 已经存在
     */
    void load(Class clazz);
}
