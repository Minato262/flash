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
import org.flashframework.core.properties.FlashProperties;
import org.flashframework.core.properties.PropertiesAware;

import java.util.Properties;

/**
 * flashframework 框架自带的 Log，主要打印框架启动时的 Log 日志。
 *
 * @author kay
 * @version v2.0
 */
public class LogConfig {

    /** 是否启动 flashframework 框架自带的 Log */
    private static boolean enabled;

    /** Log 日志打印等级 */
    private static Level level;

    /** Log 日志打印的文件路径 */
    private static String file;

    static {
        Properties properties = FlashProperties.INSTANCE_FLASH_LOG.load();

        PropertiesAware aware = new PropertiesAware();
        aware.setProperties(properties);
        String strEnabled = aware.getProperties("enabled");
        String strLevel = aware.getProperties("level");
        String strFile = aware.getProperties("file");

        enabled = Enabled.getEnabled(strEnabled);
        level = Level.getLevel(strLevel);
        file = strFile.equals("") ? "logs/out.log" : strFile;
    }

    /**
     * 初始化 Log 配置
     */
    public static void init() {
        if (enabled) {
            setConfigurator();
        }
    }

    /*
     * 自定义输出格式说明
     *
     * %p 输出优先级，即DEBUG，INFO，WARN，ERROR
     * %r 输出自应用启动到输出该 log 信息耗费的毫秒数
     * %c 输出所属的类目，通常就是所在类的全名
     * %t 输出产生该日志事件的线程名
     * %n 输出一个回车换行符，Windows平台为"/r/n"，Unix平台为"/n"
     * %d 输出日志时间点的日期或时间，默认输出格式为 ISO8601，也可以在其后指定格式，比如：%d{yyyy-MM-dd HH:mm:ss}
     * %l 输出日志时间的发生位置，包括类目名、发生的线程，以及在代码中的行数
     *
     *
     * 输出格式说明
     *
     * Appender 为日志输出目的，appender 有以下几种：
     * org.apache.log4j.ConsoleAppender(控制台)
     * org.apache.log4j.FileAppender(文件)
     * org.apache.log4j.DailyRollingFileAppender(每天产生一个日志文件)
     * org.apache.log4j.RollingFileAppender(文件大小达到指定尺寸的时候产生一个新的文件)
     * org.apache.log4j.WriterAppender(将日志信息以流格式发生到任意指定的地方)
     *
     * Layout 为日志输出布局，layout 有以下几种：
     * org.apache.log4j.HTMLLayout(以HTML表格形式布局)
     * org.apache.log4j.PatternLayout(可以灵活地指定布局模式)
     * org.apache.log4j.SimpleLayout(包含日志信息的级别和信息字符串)
     * org.apache.log4j.TTCCLayout(包含日志产生的时间、线程、类别等等信息)
     */

    /**
     * 设置 Log 配置主要包括：日志输出类型、输出目的、输出布局。
     */
    private static void setConfigurator() {
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
