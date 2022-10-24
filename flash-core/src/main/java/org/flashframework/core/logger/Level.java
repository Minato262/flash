/*
 * Copyright 2017-2019 the original author or authors.
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
package org.flashframework.core.logger;

/**
 * 框架日志常用级别常量
 *
 * @author kay
 * @version v2.0
 */
public enum Level {

    /**
     * 日志 打印等级 DEBUG
     */
    DEBUG("debug"),

    /**
     * 日志 打印等级 WARN
     */
    WARN("warn"),

    /**
     * 日志 打印等级 INFO
     */
    INFO("info"),

    /**
     * 日志 打印等级 ERROR
     */
    ERROR("error");

    private final String level;

    Level(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public static Level getLevel(String strLevel) {
        for (Level level : Level.values()) {
            if (level.getLevel().equalsIgnoreCase(strLevel)) {
                return level;
            }
        }
        return Level.DEBUG;
    }
}
