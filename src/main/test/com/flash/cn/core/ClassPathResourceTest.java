package com.flash.cn.core;

import com.flash.cn.BeforeTest;
import org.junit.Test;

/**
 * {@link ClassPathResource} Test.
 *
 * @author kay
 * @version v1.0
 */
public class ClassPathResourceTest extends BeforeTest {

    @Test
    public void test1() {
        ClassPathResource classPathResource = new ClassPathResource();
        classPathResource.getClassName("com.flash.cn.factory");
    }
}
