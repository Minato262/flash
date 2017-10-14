/*
 * Copyright 2017-2017 the original author or authors.
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
package com.flash.cn.core;

import com.flash.cn.BeforeTest;
import com.flash.cn.annotation.Autowired;
import com.flash.cn.beans.BeanContainer;
import com.flash.cn.core.factory.Ioc;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;

/**
 * {@link BeanContainer} Test.
 *
 * @author kay
 * @version v1.0
 */
public class BeanContainerTest extends BeforeTest {

    @Test
    public void test() {
        MyThread[] array = new MyThread[10];
        for (int i = 0; i < 10; i++) {
            array[i] = new MyThread();
            array[i].start();
        }
    }

    private class MyThread extends Thread {

        @Override
        public void run() {
            BeanContainer container = BeanContainer.getInstance();
            System.out.println(container.get("ioc"));
        }
    }

    @Test
    public void test1() {
        BeanContainer container = BeanContainer.getInstance();
        Ioc ioc = container.get("ioc");
        System.out.println(ioc);
        System.out.println(ioc.getFather());
        System.out.println(ioc.getPeople());
        System.out.println(ioc.getUser());
    }

    @Test
    public void test2() throws Exception {
        ClassPathResource classPathResource = new ClassPathResource();
        List<Class<?>> classes = classPathResource.getClasses();
        for (Class<?> clazz : classes) {
            Field[] fields = Class.forName(clazz.getName()).getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                Autowired hasAnnotation = field.getAnnotation(Autowired.class);
                if (hasAnnotation != null) {
                    Object obj = Class.forName(clazz.getName()).newInstance();
                    System.out.println(field.getName());
                    System.out.println(clazz);
                    System.out.println(field.get(obj));
                    field.set(obj, factory.getBean(field.getName()));
                    System.out.println(field.get(obj));
                }
            }
        }
    }
}


