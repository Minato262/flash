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
package org.flashframework.core.logger;

import org.apache.log4j.PropertyConfigurator;
import org.flashframework.core.Unicode;
import org.flashframework.core.config.LoadProperties;
import org.flashframework.core.util.Assert;

import java.util.Properties;

/**
 * Log 常用设置
 *
 * @author kay
 * @version v2.0
 */
public class LogConfig {

    private static boolean root;

    private static Level level;

    private static String file;

    static {
        String strRoot = LoadProperties.INSTANCE_FLASH_LOG.load("root");
        String strLevel = LoadProperties.INSTANCE_FLASH_LOG.load("level");
        String strFile = LoadProperties.INSTANCE_FLASH_LOG.load("file");

        root = Root.getIsRoot(strRoot);
        level = Level.getLogLevel(strLevel);
        file = strFile.equals("") ? "logs/out.log" : strFile;
    }

    public static void setLevel(Level logLevel) {
        Assert.isNotNull(logLevel);
        level = logLevel;
    }

    public static void setFileUrl(String fileUrl) {
        Assert.isNotEmpty(fileUrl);
        file = fileUrl;
    }

    public static void init() {
        if (!root) {
            return;
        }

        Properties prop = new Properties();
        prop.setProperty("log4j.rootLogger", level.getLevel() + ", toConsole, toFile");
        prop.setProperty("log4j.appender.file.encoding", Unicode.UTF_8.getCode());

        prop.setProperty("log4j.appender.toConsole", "org.apache.log4j.ConsoleAppender");
        prop.setProperty("log4j.appender.toConsole.Target", "System.out");
        prop.setProperty("log4j.appender.toConsole.layout", "org.apache.log4j.PatternLayout");
        prop.setProperty("log4j.appender.toConsole.layout.ConversionPattern", "[%d{yyyy-MM-dd HH:mm:ss}][flashframework %p] %m%n");

        prop.setProperty("log4j.appender.toFile.file", file);
        prop.setProperty("log4j.appender.toFile", "org.apache.log4j.DailyRollingFileAppender");
        prop.setProperty("log4j.appender.toFile.Append", "true");
        prop.setProperty("log4j.appender.toFile.Threshold", level.getLevel());
        prop.setProperty("log4j.appender.toFile.layout", "org.apache.log4j.PatternLayout");
        prop.setProperty("log4j.appender.toFile.layout.ConversionPattern", "[%d{yyyy-MM-dd HH:mm:ss}][flashframework %p] %m%n");
        prop.setProperty("log4j.appender.toFile.DatePattern", "'.'yyyy-MM-dd'.log'");
        PropertyConfigurator.configure(prop);
    }
}
