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
import org.flashframework.beans.container.BeanContainerAware;
import org.flashframework.beans.container.BeanContainerInitFailureException;
import org.flashframework.beans.factory.BeanDefinitionFactory;
import org.flashframework.beans.factory.BeanDefinitionRegistry;
import org.flashframework.beans.factory.BeanDefinitionResolution;
import org.flashframework.core.ClassResourceLoader;
import org.flashframework.core.Resource;
import org.flashframework.beans.*;

/**
 * 应用上下环境抽象类
 * <p>用于初始化上下文，开启容器</p>
 *
 * @author kay
 * @version v1.0
 */
abstract class AbstractApplicationContext implements ApplicationContext {

    /*
     * 概况
     * 这个抽象类的设计目的主要是：初始化 Bean 容器，设置上下文环境，为整个应用提供 IOC 支持。
     * 其中，初始化容器的过程最为重要。它包括 刷新容器，然后扫描，解析，注册 Bean Definition
     * 最后 载入类与方法注解。整个过程就初试化完成。
     */

    /** Bean 容器 */
    private BeanContainer container = BeanContainerAware.getInstance();

    /**
     * 默认构造器
     */
    AbstractApplicationContext() {
        init();
    }

    /**
     * 初始化上下文环境以及初始化容器
     *
     * @throws BeanContainerInitFailureException 如果 Bean 容器初始化失败
     */
    private void init() {
        if (container.isEmpty()) {
            Resource resource = new ClassResourceLoader();
            BeanDefinitionFactory factory = loadBeanDefinition();
            Resolution resolution = new BeanDefinitionResolution(resource, factory);
            try {
                Registry beanDefinition = new BeanDefinitionRegistry(resolution);
                // 刷新，扫描 解析 注册 Bean Definition，初始化 Bean 容器
                beanDefinition.refresh();
            }
            catch (BeanRuntimeException e) {
                // 清空 Bean Definition 注册表
                resolution.clear();
                // 清空 Bean 容器
                container.clear();
                throw new BeanContainerInitFailureException(e);
            }
        }
    }

    /**
     * BeanDefinition 工厂，用于载入 BeanDefinition 到 BeanDefinition 注册表中
     *
     * @return BeanDefinition 工厂
     */
    protected abstract BeanDefinitionFactory loadBeanDefinition();

    /**
     * 获取 Bean 容器
     *
     * @return Bean 容器
     */
    protected BeanContainer getBeanContainer() {
        return container;
    }

    /**
     * 根据 Bean 名称，获取 Bean 实例
     *
     * @param name 想获取 Bean 的名称（一定不能为空）
     * @return 获取 bean 对象
     * @throws BeanContainerInitFailureException 如果 Bean容器初始化失败
     */
    @Override
    public Object getBean(String name) {
        throw new BeanContainerInitFailureException();
    }
}
