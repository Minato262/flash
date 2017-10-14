/*
 * Copyright 2017-2017 the original author or authors.
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
package com.flash.cn.context;

import com.flash.cn.beans.*;
import com.flash.cn.core.ClassPathResource;
import com.flash.cn.core.Resource;

/**
 * @author kay
 * @version v1.0
 */
public abstract class AbstractApplicationContext {

    /**
     * Bean 容器
     */
    protected BeanContainer container = BeanContainer.getInstance();

    protected void init() {
        Resource resource = new ClassPathResource();
        BeanDefinitionTable beanDefinitionTable = new BeanDefinitionResolution(resource);
        try {
            beanDefinitionTable = new BeanDefinitionResolution(resource);
            BeanDefinition beanDefinition = new BeanDefinitionRegistry(beanDefinitionTable, container);
            beanDefinition.refresh();
        }
        catch (BeanException e) {
            beanDefinitionTable.clear();
            container.clear();
        }
    }
}
