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
package org.flashframework;

import org.flashframework.core.logger.LogConfig;
import org.flashframework.core.logger.LogLevel;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link LogConfig} Test
 *
 * @author kay
 * @version v2.0
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
        LogConfig.setLevel(LogLevel.ERROR);
        LogConfig.setFileUrl("");
        LogConfig.init();
        log.debug("log debug");
        log.info("log info");
        log.warn("log warn");
        log.error("log error");
        System.out.println();

        LogConfig.setLevel(LogLevel.WARN);
        log.debug("log debug");
        log.info("log info");
        log.warn("log warn");
        log.error("log error");
        System.out.println();

        LogConfig.setLevel(LogLevel.INFO);
        log.debug("log debug");
        log.info("log info");
        log.warn("log warn");
        log.error("log error");
        System.out.println();

        LogConfig.setLevel(LogLevel.ERROR);
        log.debug("log debug");
        log.info("log info");
        log.warn("log warn");
        log.error("log error");
    }
}
