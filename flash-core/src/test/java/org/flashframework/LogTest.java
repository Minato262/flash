package org.flashframework;

import org.flashframework.core.config.LogConfiguration;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kay
 * @version v1.0
 */
public class LogTest {

    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void test() {
        LogConfiguration.initLog();
        logger.debug("log debug");
        logger.info("log info");
        logger.warn("log warn");
        logger.error("log error");

        logger.debug("log1 debug");
        logger.info("log1 info");
        logger.warn("log1 warn");
        logger.error("log1 error");
    }

    @Test
    public void test1() {
        //
    }

    @Test
    public void test2() {
        //
    }
}
