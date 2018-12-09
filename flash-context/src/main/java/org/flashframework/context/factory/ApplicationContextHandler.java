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
import org.flashframework.beans.handle.AbstractHandler;
import org.flashframework.context.annotation.Component;
import org.flashframework.context.annotation.Service;
import org.flashframework.core.util.Assert;

import java.security.InvalidParameterException;

/**
 * 应用环境默认拦截器
 *
 * @author kay
 * @version v2.0
 */
public class ApplicationContextHandler extends AbstractHandler {

    /**
     * 根据 Class，载入类注解信息
     * <p>默认载入 Repository，Component, Service 注解</p>
     *
     * @param clazz class 信息
     * @throws InvalidParameterException 如果 Class 为null
     */
    @Override
    public void load(Class clazz) {
        Assert.isNotNull(clazz);

        Repository annotation = (Repository) clazz.getAnnotation(Repository.class);
        if (annotation != null) {
            String name = super.getSimpleName(annotation.value(), clazz);
            super.put(name, clazz);
        }
        Component annotation1 = (Component) clazz.getAnnotation(Component.class);
        if (annotation1 != null) {
            String name = super.getSimpleName(annotation1.value(), clazz);
            super.put(name, clazz);
        }
        Service annotation2 = (Service) clazz.getAnnotation(Service.class);
        if (annotation2 != null) {
            String name = super.getSimpleName(annotation2.value(), clazz);
            super.put(name, clazz);
        }
    }
}
