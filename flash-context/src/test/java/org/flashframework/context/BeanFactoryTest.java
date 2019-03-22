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
package org.flashframework.context;

import org.flashframework.beans.annotation.Autowired;
import org.flashframework.beans.factory.BeanFactory;
import org.flashframework.context.factory.ApplicationContextFactory;
import org.flashframework.context.factory.People;
import org.junit.Assert;
import org.junit.Test;

/**
 * {@link ApplicationContextFactory} test.
 *
 * @author kay
 * @version v1.0
 */
public class BeanFactoryTest extends BeforeTest {

    @Autowired
    private People people;

    @Test
    public void test() {
        People people = (People) factory.getBean("people");
        Assert.assertNotNull(people);

        people.setAge(1);
        people.setName("name");

        People people1 = (People) factory.getBean("people");
        Assert.assertNotNull(people1);

//        ServiceBean test =  (ServiceBean) factory.getBean("service");
//        Assert.assertNotNull(test);
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

        BeanFactory factory2 = new ApplicationContextFactory();
        People people2 = (People) factory2.getBean(People.class);
        Assert.assertNotNull(people2);
    }

    @Test
    public void test2() {
        people.getAge();
    }
}
