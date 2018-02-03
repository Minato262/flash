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
 * Bean 工厂接口，IOC 中最核心的接口
 *
 * @author kay
 * @version v1.0
 */
public interface BeanFactory {

    /**
     * 根据 Bean 的名称获取 Bean 实例对象
     *
     * @param name 想获取 Bean 的名称（一定不能为空）
     * @return 获取 bean 实例对象
     */
    Object getBean(String name);
}
