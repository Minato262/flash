package com.flash.cn.core;

import com.flash.cn.BeforeTest;
import org.junit.Test;

import java.util.List;

/**
 * {@link ClassPathResource} Test.
 *
 * @author kay
 * @version v1.0
 */
public class ClassPathResourceTest extends BeforeTest {

    @Test
    public void test() {
        ClassPathResource classPathResource = new ClassPathResource();
        List<String> list = classPathResource.getClassName("com.flash.cn");
        for (String str : list) {
            System.out.println(str);
        }
    }
}
