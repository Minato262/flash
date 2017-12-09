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
package org.flashframework.beans.container;

/**
 * 容器模式枚举，容器分为单例和原型模式。
 * <p>
 * 单例模式，容器启动时，创建所有的 Bean 实例，以后不会再创建新的实例。
 * 原型模式，会在使用时，创建和载入相应的 Bean 实例。
 * </p>
 * Bean 使用注解, 默认的是单例模式方式。
 *
 * @author kay
 * @version v1.0
 */
public enum BeanContainerMode {

    /**
     * 单例模式，一个应用只能有一个实例
     */
    SINGLETON(),

    /**
     * 原型模式，每次调用时调用多个实例
     */
    PROTOTYPE()
}
