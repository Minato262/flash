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
package org.flashframework.context.factory;

import org.flashframework.beans.annotation.Repository;
import org.flashframework.beans.factory.BeanDefinitionTableFactory;
import org.flashframework.context.annotation.Service;
import org.flashframework.core.util.Assert;
import org.flashframework.core.util.StringUtils;

/**
 * BeanDefinition 默认工厂
 *
 * @author kay
 * @version v2.0
 */
public class DefaultBeanDefinitionFactory extends BeanDefinitionTableFactory {

    /**
     * 根据 Class，载入类注解信息
     * <p>默认载入 Repository，Service 注解</p>
     *
     * @param clazz class 信息
     * @throws IllegalArgumentException 如果Class为null
     */
    @Override
    public void load(Class clazz) {
        Assert.isNotNull(clazz);
        Repository annotation = (Repository) clazz.getAnnotation(Repository.class);
        if (annotation != null) {
            super.put(annotation.value(), clazz);
        }
        Service annotation1 = (Service) clazz.getAnnotation(Service.class);
        if (annotation1 != null) {
            String name = super.getSimpleName(annotation1.value(), clazz);
            super.put(name, clazz);
        }
    }
}
