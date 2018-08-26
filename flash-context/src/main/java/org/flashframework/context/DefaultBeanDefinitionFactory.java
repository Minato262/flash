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
package org.flashframework.context;

import org.flashframework.beans.annotation.Controller;
import org.flashframework.beans.annotation.Repository;
import org.flashframework.beans.annotation.Resource;
import org.flashframework.beans.annotation.Service;
import org.flashframework.beans.factory.BeanDefinitionTableFactory;
import org.flashframework.util.Assert;

import java.lang.annotation.Annotation;

/**
 * BeanDefinition 默认工厂
 *
 * @author kay
 * @version v2.0
 */
public class DefaultBeanDefinitionFactory extends BeanDefinitionTableFactory {

    /**
     * 根据 Class，载入类注解信息
     * <p>默认载入 Repository，Service，Controller，Resource 注解</p>
     *
     * @param clazz class 信息
     * @throws IllegalArgumentException 如果Class为null，则抛出异常
     */
    @Override
    public void load(Class clazz) {
        Assert.isNotNull(clazz);
        Repository annotation = (Repository) clazz.getAnnotation(Repository.class);
        if (annotation != null) {
            super.put(annotation.value(), clazz);
            return;
        }
        Service annotation1 = (Service) clazz.getAnnotation(Service.class);
        if (annotation1 != null) {
            super.put(annotation1.value(), clazz);
            return;
        }
        Controller annotation2 = (Controller) clazz.getAnnotation(Controller.class);
        if (annotation2 != null) {
            super.put(clazz);
            return;
        }

        Resource annotation3 = (Resource) clazz.getAnnotation(Resource.class);
        if (annotation3 != null) {
            super.put(annotation3.value(), clazz);
        }
    }
}
