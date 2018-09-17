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

import org.flashframework.beans.factory.BeanDefinitionFactory;
import org.flashframework.context.factory.ApplicationContextFactory;

/**
 * web 应用关系环境工厂，包装容器，为Web提供使用环境
 *
 * @author kay
 * @version v2.0
 */
public class WebApplicationContextFactory extends ApplicationContextFactory {

    /**
     * 载入 BeanDefinition
     *
     * @return BeanDefinition 工厂
     */
    @Override
    protected BeanDefinitionFactory loadBeanDefinition() {
        return new WebBeanDefinitionFactory();
    }
}
