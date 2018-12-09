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
package org.flashframework.core.properties;

import org.flashframework.core.util.Assert;

import java.security.InvalidParameterException;
import java.util.Properties;

/**
 * 配置文件枚举，用于载入默认框架文件配置
 *
 * @author kay
 * @version v2.0
 */
public enum FlashFile {
    /**
     * Flash 主要配置
     */
    INSTANCE_FLASH("/config/flash.properties"),

    /**
     * Flash Aop配置
     */
    INSTANCE_FLASH_AOP("/config/flash_aop.properties"),

    /**
     * Flash 日志配置
     */
    INSTANCE_FLASH_LOG("/config/flash_log.properties");

    private Properties prop;

    /**
     * 带有配置文件路径的构造器
     *
     * @param path 配置文件路径
     */
    FlashFile(String path) {
        this.prop = PropertiesFactory.load(path);
    }

    /**
     * 载入配置，获取 Properties 配置值
     *
     * @param propertyName 配置名称（一定不能为空）
     * @return 获取 Properties 配置值
     * @throws InvalidParameterException 如果字符串为空
     */
    public String load(String propertyName) {
        Assert.isNotEmpty(propertyName);
        for (final String key : prop.stringPropertyNames()) {
            if (propertyName.equals(key)) {
                return prop.getProperty(key);
            }
        }
        return "";
    }
}
