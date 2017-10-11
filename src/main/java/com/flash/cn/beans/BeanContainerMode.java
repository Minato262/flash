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

import com.flash.cn.util.LoadProperties;

/**
 * 容器模式枚举，容器分为 单例和原型模式。
 * <p>
 * 单例模式，容器启动时，创建所有的 Bean 实例，以后不会再创建新的实例。
 * 原型模式，会在使用时，创建和载入相应的 Bean 实例。
 * </p>
 * Bean 使用注解, 默认的是单例模式方式。
 *
 * @author kay
 * @version v1.0
 */
public final class BeanContainerMode {

    /** 配置模式 */
    private String mode;

    /** 默认软件模式 */
    private static final String FLASH_PROPERTIES_MODE = "containerModes";

    /** 单例模式 */
    public static final String FLASH_PROPERTIES_SINGLETON = "singleton";

    /** 原型模式 */
    public static final String FLASH_PROPERTIES_PROTOTYPE = "prototype";

    /** 静态对象 */
    private static BeanContainerMode instance = new BeanContainerMode();

    /** 单例模式生成对象 */
    public static BeanContainerMode getInstance() {
        return instance;
    }

    /**
     * 默认构造器，载入配置
     */
    private BeanContainerMode() {
        mode = new LoadProperties().load(FLASH_PROPERTIES_MODE);
    }

    /**
     * 获取容器配置模式
     *
     * @return 是否是单例模式
     */
    public boolean isSingleton() {
        return !FLASH_PROPERTIES_PROTOTYPE.equals(mode);
    }
}
