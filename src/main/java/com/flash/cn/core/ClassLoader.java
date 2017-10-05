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
package com.flash.cn.core;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Class 资源载入
 *
 * @author kay
 * @version v1.0
 */
class ClassLoader {

    /**
     * 根据来源获取，目标 URL 资源
     *
     * @param name 资源名称
     * @return URL 元素资源
     * @throw ClassPathResourceException
     */
    public static Enumeration<URL> getEnumeration(String name) {
        try {
            return Thread.currentThread().getContextClassLoader().getResources(name);
        }
        catch (IOException e) {
            throw new ClassPathResourceException(e);
        }
    }

    /**
     * 载入 Class 类
     *
     * @param name 资源名称
     * @return 载入的 Class 类
     * @throw ClassPathResourceException
     */
    public static Class<?> loadClass(String name) {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(name);
        }
        catch (ClassNotFoundException e) {
            throw new ClassPathResourceException(e);
        }
    }
}
