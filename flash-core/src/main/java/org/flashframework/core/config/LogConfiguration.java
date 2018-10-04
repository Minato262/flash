package org.flashframework.core.config;

import java.util.Properties;

/**
 * @author kay
 * @version v1.0
 */
public class LogConfiguration {

    public void initLog() {
        //声明日志文件存储路径以及文件名、格式
        Properties prop = new Properties();
        //配置日志输出的格式
        prop.setProperty("log4j.rootLogger", "debug, toConsole, toFile");
        prop.setProperty("log4j.appender.file.encoding", "UTF-8");

        prop.setProperty("log4j.appender.toConsole", "org.apache.log4j.ConsoleAppender");
        prop.setProperty("log4j.appender.toConsole.Target", "System.out");
        prop.setProperty("log4j.appender.toConsole.layout", "org.apache.log4j.PatternLayout ");
        prop.setProperty("log4j.appender.toConsole.layout.ConversionPattern", "[log test][%d{yyyy-MM-dd HH:mm:ss}] [%p] %m%n");

        prop.setProperty("log4j.appender.toFile.file", "logs/out.log");
        //每天产生一个日志文件
        prop.setProperty("log4j.appender.toFile", "org.apache.log4j.DailyRollingFileAppender");
        //服务器启动日志是追加，false：服务器启动后会生成日志文件把老的覆盖掉
        prop.setProperty("log4j.appender.toFile.Append", "true");
        prop.setProperty("log4j.appender.toFile.Threshold", "debug");
        prop.setProperty("log4j.appender.toFile.layout", "org.apache.log4j.PatternLayout");
        prop.setProperty("log4j.appender.toFile.layout.ConversionPattern", "[log test][%d{yyyy-MM-dd HH:mm:ss}] [%p] %m%n");
        //[2017-03-31 14:10:44] [ERROR] HttpResponseAnalyze:31 - Not equal
        //prop.setProperty("log4j.appender.toFile.layout.ConversionPattern", "[%d{yyyy-MM-dd HH:mm:ss}] [%p] %c{1}:%L - %m%n");
        //设置每天生成一个文件名后添加的名称,备份名称：年月日.log
        prop.setProperty("log4j.appender.toFile.DatePattern", "'.'yyyy-MM-dd'.log'");

        //使配置生效
        //PropertyConfigurator.configure(prop);
    }
}
