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

import org.flashframework.beans.util.BeanCreateFailureException;
import org.flashframework.beans.container.BeanContainer;
import org.flashframework.beans.handle.Handler;
import org.flashframework.beans.factory.BeanDefinitionWrapImpl;
import org.flashframework.core.util.Assert;

import java.security.InvalidParameterException;

/**
 * 应用环境工厂，包装容器，为容器提供使用上下文环境
 *
 * @author kay
 * @version v1.0
 */
public class ApplicationContextFactory extends AbstractApplicationContext {

    /**
     * Bean 容器
     */
    private BeanContainer container = getBeanContainer();

    /**
     * Bean Definition 工具类
     */
    private BeanDefinitionWrapImpl beanDefinition = new BeanDefinitionWrapImpl();

    /**
     * 默认构造器
     */
    public ApplicationContextFactory() {
        super();
    }

    /**
     * 载入 BeanDefinition
     *
     * @return BeanDefinition 工厂
     */
    @Override
    protected Handler getHandle() {
        return new ApplicationContextHandler();
    }

    /**
     * 根据 Bean 名称，获取 Bean 实例
     *
     * @param name 想获取 Bean 的名称（一定不能为空）
     * @return 获取 bean 对象
     * @throws InvalidParameterException  如果字符串为空
     * @throws BeanCreateFailureException 如果对象创建失败
     */
    @Override
    public Object getBean(String name) {
        Assert.isNotEmpty(name);

        Object obj = container.get(name);
        if (obj instanceof Class) {
            // 根据 Bean 名称，获取 Bean 实例信息，然后根据 Bean 实例信息载入方法注解
            Class clazz = (Class) container.get(name);
            return beanDefinition.loadBeanDefinition(clazz);
        }
        else {
            return obj;
        }
    }

    /**
     * 根据 Bean 的信息获取 Bean 实例对象
     *
     * @param clazz 想获取 Bean 的信息（一定不能为null）
     * @return 获取 bean 实例对象
     * @throws InvalidParameterException  如果对象信息为 null
     * @throws BeanCreateFailureException 如果对象创建失败
     */
    @Override
    public <T> T getBean(Class<T> clazz) {
        Assert.isNotNull(clazz);
        return beanDefinition.loadBeanDefinition(clazz);
    }
}
