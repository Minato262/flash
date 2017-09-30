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
        String packageName = new LoadProperties().load("packageName");
        System.out.println(packageName);
    }

    @Test
    public void test1() throws IOException {
        String containerModes = new LoadProperties().load("containerModes");
        System.out.println(containerModes);
    }
}
