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
package org.flashframework.web.context;

import org.flashframework.context.DefaultBeanDefinitionFactory;
import org.flashframework.web.mvc.annotation.RestController;

/**
 * BeanDefinition web 工厂
 *
 * @author kay
 * @version v2.0
 */
public class WebBeanDefinitionFactory extends DefaultBeanDefinitionFactory {

    /**
     * 根据 Class，载入类注解信息
     * <p>默认载入 Repository，Service，Controller，Resource，RestController 注解</p>
     *
     * @param clazz class 信息
     * @throws IllegalArgumentException 如果Class为null
     */
    @Override
    public void load(Class clazz) {
        super.load(clazz);
        RestController annotation = (RestController) clazz.getAnnotation(RestController.class);
        if (annotation != null) {
            put(clazz);
        }
    }
}
