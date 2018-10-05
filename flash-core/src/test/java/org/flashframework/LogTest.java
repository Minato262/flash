package org.flashframework;

import org.flashframework.core.log.LogConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kay
 * @version v1.0
 */
public class LogTest {

    private static final Logger log = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void test() {
        LogConfig.init();
        log.debug("log debug");
        log.info("log info");
        log.warn("log warn");
        log.error("log error");

        log.debug("log1 debug");
        log.info("log1 info");
        log.warn("log1 warn");
        log.error("log1 error");
    }

    @Test
    public void test1() {
        LogConfig.init();
        if (log.isDebugEnabled()) {
            log.debug("log debug");
            log.info("log info");
            log.warn("log warn");
            log.error("log error");
        }
        if (log.isInfoEnabled()) {
            log.debug("log debug");
            log.info("log info");
            log.warn("log warn");
            log.error("log error");
        }
    }

    @Test
    public void test2() {
        //
    }
}
