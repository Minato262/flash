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

/**
 * 应用关系环境工厂，包装容器，为容器提供使用环境
 *
 * @author kay
 * @version v1.0
 */
public class ApplicationContextFactory extends AbstractApplicationContext implements ApplicationContext {

    /**
     * 默认构造器
     */
    public ApplicationContextFactory() {
        super();
    }

    /**
     * 根据 Bean 名称，获取 Bean 实例
     *
     * @param name 想获取 Bean 的名称（一定不能为空）
     * @param <T>  获取容器中的 Bean 对象
     * @return 获取 bean 对象
     * @throw ClassCastException 如果 Class 对象冲突
     */
    @Override
    public <T> T getBean(String name) {
        return super.get(name);
    }
}
