package com.flash.cn.util;

import org.junit.Test;

import java.io.IOException;

/**
 * {@link LoadProperties} Test.
 *
 * @author kay
 * @version v1.0
 */
public class PropertiesUtilsTest {

    @Test
    public void test() throws IOException {
        String packageName = LoadProperties.load("/config/flash.properties", "packageName");
        System.out.println(packageName);
    }

    @Test
    public void test1() throws IOException {
        String containerModes = LoadProperties.load("/config/flash.properties", "containerModes");
        System.out.println(containerModes);
    }
}
