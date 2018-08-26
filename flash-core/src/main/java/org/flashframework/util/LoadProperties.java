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
package org.flashframework.util;

import java.io.*;
import java.util.Properties;

/**
 * 配置工具类，单例模式，用于载入默认配置
 *
 * @author kay
 * @version v1.0
 */
public enum LoadProperties {
    INSTANCE("/config/flash.properties");

    private String path;

    /**
     * 带有配置文件路径的构造器
     *
     * @param path 配置文件路径
     */
    LoadProperties(String path){
        this.path = path;
    }

    /**
     * 载入配置，获取 Properties 配置值，如果配置项不存在，则返回为空
     *
     * @param propertyPath 配置路径
     * @param propertyName 配置名称
     * @return 获取 Properties 配置值
     * @throws IOException I/O 异常
     */
    private String load(String propertyPath, String propertyName) throws IOException {
        Properties prop = new Properties();
        InputStream in = null;
        try {
            in = Object.class.getResourceAsStream(propertyPath);
            prop.load(in);
            for (String key : prop.stringPropertyNames()) {
                if (propertyName.equals(key)) {
                    return prop.getProperty(key);
                }
            }
            return "";
        }
        finally {
            if (in != null) {
                in.close();
            }
        }
    }

    /**
     * 载入配置，获取 Properties 配置值
     *
     * @param propertyName 配置名称（一定不能为空）
     * @return 获取 Properties 配置值
     * @throws IllegalArgumentException 如果字符串为空
     */
    public String load(String propertyName) {
        Assert.isNotEmpty(propertyName);
        try {
            return load(path, propertyName);
        }
        catch (IOException e) {
            return "";
        }
    }
}
