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
package com.flash.cn.beans;

/**
 * @author kay
 * @version v1.0
 */
public final class BeanDefinitionTableAware implements BeanDefinitionAware {

    /** Bean Definition 注册表 */
    private static BeanDefinitionTable registryTable = new ConcurrentBeanDefinitionMap();

    private static BeanDefinitionAware aware = new BeanDefinitionTableAware();

    private BeanDefinitionTableAware(){
        //
    }

    public static BeanDefinitionAware getInstance(){
        synchronized (BeanDefinitionTableAware.class){
            return aware;
        }
    }

    @Override
    public BeanDefinitionTable getTable() {
        return registryTable;
    }
}
