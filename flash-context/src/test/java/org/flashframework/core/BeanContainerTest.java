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
package org.flashframework.core;

import org.flashframework.BeforeTest;
import org.flashframework.beans.annotation.Autowired;
import org.flashframework.beans.container.BeanContainerAware;
import org.flashframework.beans.container.BeanContainer;
import org.flashframework.core.factory.Ioc;
import org.flashframework.util.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;

/**
 * {@link BeanContainerAware} Test.
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
            BeanContainer container = BeanContainerAware.getInstance();
            Assert.isNotNull(container.get("ioc"));
        }
    }

    @Test
    public void test1() {
        BeanContainer container = BeanContainerAware.getInstance();
        Ioc ioc = (Ioc) container.get("ioc");
        Assert.isNotNull(ioc);
        Assert.isNotNull(ioc);
        Assert.isNotNull(ioc.getFather());
        Assert.isNotNull(ioc.getPeople());
        Assert.isNotNull(ioc.getUser());
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
                    Assert.isNotNull(field.getName());
                    Assert.isNotNull(clazz);
                    Assert.isNotNull(field.get(obj));
                    field.set(obj, factory.getBean(field.getName()));
                    Assert.isNotNull(field.get(obj));
                }
            }
        }
    }
}


