package com.flash.cn.core;

import com.flash.cn.BeforeTest;
import com.flash.cn.context.ApplicationContextFactory;
import com.flash.cn.beans.BeanFactory;
import com.flash.cn.core.factory.Bean;
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
        List<Class<?>> classes = classPathResource.getClasses();
        BeanFactory factory = new ApplicationContextFactory();
        for (Class<?> clazz : classes) {
            Bean people = factory.getBean(clazz.getName());
            assert people != null;
            System.out.println(people);
            System.out.println(people.getAge());
            System.out.println(people.getName());
        }
    }
}
