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

import org.flashframework.aop.annotation.Aspect;
import org.flashframework.context.factory.ApplicationContextHandler;

/**
 * Aop 注解处理器
 *
 * @author kay
 * @version v2.0
 */
public class AspectContextHandler extends ApplicationContextHandler {

    /**
     * Aop 切点注册表
     */
    private AspectPointcutTable table = AspectPointcutTableAware.getInstance();

    /**
     * 根据 Class，载入类注解信息
     * <p>默认载入 Aspect 注解</p>
     *
     * @param clazz class 信息
     * @throws IllegalArgumentException 如果Class为null，则抛出异常
     */
    @Override
    public void load(Class clazz) {
        super.load(clazz);
        Aspect annotation = (Aspect) clazz.getAnnotation(Aspect.class);
        if (annotation != null) {
            String name = super.getSimpleName(clazz);
            table.put(name, clazz);
        }
    }
}
