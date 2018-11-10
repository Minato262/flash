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

import static org.flashframework.core.properties.FlashFile.*;

/**
 * 配置项枚举，用于载入默认框架文件配置中的配置项
 *
 * @author kay
 * @version v2.0
 */
public enum FlashConfig {
    /**
     * Flash 扫描默认包配置
     */
    FLASH_PACKAGE_NAME(INSTANCE_FLASH, "packageName"),

    /**
     * Flash 日志打印是否启动配置
     */
    FLASH_LOG_ENABLED(INSTANCE_FLASH_LOG, "enabled"),

    /**
     * Flash 日志打印等级配置
     */
    FLASH_LOG_LEVEL(INSTANCE_FLASH_LOG, "level"),

    /**
     * Flash 日志打印文件
     */
    FLASH_LOG_FILE(INSTANCE_FLASH_LOG, "file");

    /** 配置文件枚举 */
    private FlashFile file;

    /** 文件配置项 */
    private String item;

    /**
     * 带有配置文件路径的构造器
     *
     * @param file 文件配置项
     * @param item 文件配置项
     */
    FlashConfig(FlashFile file, String item) {
        this.file = file;
        this.item = item;
    }

    /**
     * 载入配置，获取 Properties 配置值
     *
     * @return 获取 Properties 配置值
     */
    public String load() {
        return file.load(item);
    }
}
