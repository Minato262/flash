package com.flash.cn.util;

import org.junit.Test;

import java.io.IOException;

/**
 * {@link PropertiesUtils} Test.
 *
 * @author kay
 * @version v1.0
 */
public class PropertiesUtilsTest {

    @Test
    public void test() throws IOException {
        String packageName = PropertiesUtils.load("/config/flash.properties");
        System.out.println(packageName);
    }
}
