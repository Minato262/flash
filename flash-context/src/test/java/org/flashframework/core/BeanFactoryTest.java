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

import org.flashframework.beans.factory.BeanFactory;
import org.flashframework.context.factory.ApplicationContextFactory;
import org.flashframework.core.factory.People;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * {@link ApplicationContextFactory} test.
 *
 * @author kay
 * @version v1.0
 */
public class BeanFactoryTest extends BeforeTest {

    @Test
    public void test() {
        People people = (People) factory.getBean("people");
        Assert.assertNotNull(people);

        people.setAge(1);
        people.setName("name");

        People people1 = (People) factory.getBean("people");
        Assert.assertNotNull(people1);
    }

    @Test
    public void test1() {
        BeanFactory factory = new ApplicationContextFactory();
        People people = (People) factory.getBean("people");
        Assert.assertNotNull(people);

        people.setAge(2);

        BeanFactory factory1 = new ApplicationContextFactory();
        People people1 = (People) factory1.getBean("people");
        Assert.assertNotNull(people1);
    }

    @Test
    public void test2() throws ClassNotFoundException {
        Assert.assertNotNull(Arrays.toString(Class.forName("org.flashframework.core.factory.Ioc").getDeclaredFields()));
    }
}
