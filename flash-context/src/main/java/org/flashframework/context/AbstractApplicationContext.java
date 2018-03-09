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

import org.flashframework.beans.container.BeanContainer;
import org.flashframework.beans.container.BeanContainerInitFailureException;
import org.flashframework.beans.factory.BeanDefinitionRegistry;
import org.flashframework.beans.factory.BeanDefinitionResolution;
import org.flashframework.core.ClassPathResource;
import org.flashframework.core.Resource;
import org.flashframework.beans.*;
import org.flashframework.util.Assert;

/**
 * 应用上下环境抽象类
 * <p>初始化上下文，开启容器</p>
 *
 * @author kay
 * @version v1.0
 */
abstract class AbstractApplicationContext implements ApplicationContext {

    /*
     * 概况
     */

    /** Bean 容器 */
    private BeanContainer container;

    /**
     * 默认构造器
     */
    AbstractApplicationContext() {
        //
    }

    /**
     * 初始化上下文环境
     *
     * @throws BeanContainerInitFailureException 如果 Bean 容器初始化失败
     */
    private void init() {
        Resource resource = new ClassPathResource();
        Resolution beanDefinitionResolution = new BeanDefinitionResolution(resource);
        try {
            Registry beanDefinition = new BeanDefinitionRegistry(beanDefinitionResolution);
            beanDefinition.refresh();  // 刷新，扫描 解析 注册 Bean Definition，初始化 Bean 容器
        }
        catch (BeanRuntimeException e) {
            beanDefinitionResolution.clear();  // 清空 Bean Definition 注册表
            container.clear();  // 清空 Bean 容器
            throw new BeanContainerInitFailureException(e);
        }
    }

    /**
     * 初始化上下文环境
     *
     * @param container Bean 容器
     * @throws IllegalArgumentException 如果字符串为null
     */
    protected void init(BeanContainer container) {
        Assert.isNotNull(container);
        if (container.isEmpty()) {
            this.container = container;
            init();
        }
    }
}
