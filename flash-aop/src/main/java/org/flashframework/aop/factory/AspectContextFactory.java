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

import org.flashframework.aop.proxy.DynamicProxy;
import org.flashframework.beans.handle.Handle;
import org.flashframework.context.factory.ApplicationContextFactory;
import org.flashframework.core.logger.Enabled;
import org.flashframework.core.properties.FlashConfig;

/**
 * @author kay
 * @version v2.0
 */
public class AspectContextFactory extends ApplicationContextFactory {

    /**
     * 是否启动 flashframework 框架自带的 Aop 设置
     */
    private static boolean enabled;

    private DynamicProxy proxy = new DynamicProxy();

    static {
        final String strEnabled = FlashConfig.FLASH_AOP_ENABLED.load();
        enabled = Enabled.getEnabled(strEnabled);
    }

    /**
     * 默认构造器
     */
    public AspectContextFactory() {
        super();
    }

    /**
     * 载入 BeanDefinition
     *
     * @return BeanDefinition 工厂
     */
    @Override
    protected Handle getHandle() {
        return new AspectContextHandle();
    }

    @Override
    public Object getBean(String name) {
        if (enabled) {
            return proxy.bind(super.getBean(name));
        }
        else {
            return super.getBean(name);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getBean(Class<T> clazz) {
        if (enabled) {
            return (T) proxy.bind(super.getBean(clazz));
        }
        else {
            return super.getBean(clazz);
        }
    }
}
