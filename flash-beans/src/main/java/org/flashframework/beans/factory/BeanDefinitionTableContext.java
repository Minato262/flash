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
package org.flashframework.beans.factory;

/**
 * 这是一个抽象环境类，主要用于存放 Bean Definition 注册表相关的操作
 *
 * @author kay
 * @version v1.0
 */
public abstract class BeanDefinitionTableContext implements BeanDefinitionAware {

    /** Bean Definition 注册表 */
    private BeanDefinitionTable table = BeanDefinitionTableAware.getInstance();

    /**
     * 默认构造器
     */
    public BeanDefinitionTableContext() {
        //
    }

    /**
     * 放入 Bean Definition 注册表中
     *
     * @param key   注册表 key
     * @param clazz 注册对象内容
     * @throws BeanDefinitionConflictException 如果 Bean Definition 已经存在
     */
    protected void put(String key, Class clazz) {
        table.put(key, clazz);
    }

    /**
     * 清理注册表
     */
    @Override
    public void clear() {
        table.clear();
    }
}
