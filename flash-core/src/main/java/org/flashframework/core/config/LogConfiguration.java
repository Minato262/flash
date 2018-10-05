package org.flashframework.core.config;

import org.apache.log4j.PropertyConfigurator;

import java.util.Properties;

/**
 * @author kay
 * @version v1.0
 */
public class LogConfiguration {

    public static void initLog() {
        Properties prop = new Properties();
        prop.setProperty("log4j.rootLogger", "debug, toConsole, toFile");
        prop.setProperty("log4j.appender.file.encoding", "UTF-8");

        prop.setProperty("log4j.appender.toConsole", "org.apache.log4j.ConsoleAppender");
        prop.setProperty("log4j.appender.toConsole.Target", "System.out");
        prop.setProperty("log4j.appender.toConsole.layout", "org.apache.log4j.PatternLayout ");
        prop.setProperty("log4j.appender.toConsole.layout.ConversionPattern", "[flashframework log][%d{yyyy-MM-dd HH:mm:ss}] [%p] %m%n");

        prop.setProperty("log4j.appender.toFile.file", "logs/out.log");
        prop.setProperty("log4j.appender.toFile", "org.apache.log4j.DailyRollingFileAppender");
        prop.setProperty("log4j.appender.toFile.Append", "true");
        prop.setProperty("log4j.appender.toFile.Threshold", "debug");
        prop.setProperty("log4j.appender.toFile.layout", "org.apache.log4j.PatternLayout");
        prop.setProperty("log4j.appender.toFile.layout.ConversionPattern", "[flashframework log][%d{yyyy-MM-dd HH:mm:ss}] [%p] %m%n");
        prop.setProperty("log4j.appender.toFile.DatePattern", "'.'yyyy-MM-dd'.log'");

        //使配置生效
        PropertyConfigurator.configure(prop);
    }
}
