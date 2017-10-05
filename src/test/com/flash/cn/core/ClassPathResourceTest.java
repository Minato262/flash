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
