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
package org.flashframework;

import org.flashframework.context.ApplicationContextFactory;
import org.flashframework.beans.factory.BeanFactory;
import org.flashframework.core.factory.Ioc;
import org.flashframework.core.factory.Ioc1;
import org.flashframework.core.factory.Ioc2;
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
        People people = (People) factory.getBean("2");
        Assert.assertNotNull(people);
        Assert.assertNotNull(people.getAge());
        Assert.assertNotNull(people.getName());

        people.setAge(1);
        people.setName("name");

        People people1 = (People) factory.getBean("2");
        Assert.assertNotNull(people1);
        Assert.assertNotNull(people1.getAge());
        Assert.assertNotNull(people1.getName());
    }

    @Test
    public void test1() {
        BeanFactory factory = new ApplicationContextFactory();
        People people = (People) factory.getBean("people");
        Assert.assertNotNull(people);
        Assert.assertNotNull(people.getAge());
        Assert.assertNotNull(people.getName());

        people.setAge(2);

        BeanFactory factory1 = new ApplicationContextFactory();
        People people1 = (People) factory1.getBean("people");
        Assert.assertNotNull(people1);
        Assert.assertNotNull(people1.getAge());
        Assert.assertNotNull(people1.getName());
    }

    @Test
    public void test2() throws ClassNotFoundException {
        Assert.assertNotNull(Arrays.toString(Class.forName("org.flashframework.core.factory.Ioc").getDeclaredFields()));
    }

    @Test
    public void test3() {
        Ioc ioc = (Ioc) factory.getBean("ioc");
        Assert.assertNotNull(ioc);
        Assert.assertNotNull(ioc.getFather());
        Assert.assertNotNull(ioc.getPeople());
        Assert.assertNotNull(ioc.getUser());
    }

    @Test
    public void test4() throws ClassNotFoundException {
        //Object object = ClassUtils.newInstance("Ioc");
        //System.out.println(Arrays.toString(object.getClass().getDeclaredFields()));
    }

    @Test
    public void test5() {
        System.out.println(factory.getBean("1"));
    }

    @Test
    public void test6() {
        Ioc1 ioc1 = (Ioc1) factory.getBean("ioc1");
        Assert.assertNotNull(ioc1);
        Assert.assertNotNull(ioc1.getFather());
        Assert.assertNotNull(ioc1.getPeople());
        Assert.assertNotNull(ioc1.getUser());
    }

    @Test
    public void test7() {
        Ioc2 ioc2 = (Ioc2) factory.getBean("ioc2");
        assert ioc2 != null;
        assert ioc2.getFather() != null;
        assert ioc2.getPeople() != null;
        assert ioc2.getUser() != null;
        assert ioc2.getIoc1() != null;
        assert ioc2.getIoc1().getFather() != null;
        assert ioc2.getIoc1().getPeople() != null;
        assert ioc2.getIoc1().getUser() != null;
        assert ioc2.getIoc1().getIoc() != null;
        assert ioc2.getIoc1().getIoc().getUser() != null;
        assert ioc2.getIoc1().getIoc().getPeople() != null;
        assert ioc2.getIoc1().getIoc().getFather() != null;
    }

    @Test
    public void test8() {
        Ioc2 ioc21 = (Ioc2) factory.getBean("ioc2");
        Assert.assertNotNull(ioc21);
        Assert.assertNotNull(ioc21.getClass().getName());

        Ioc2 ioc22 = (Ioc2) factory.getBean("ioc2");
        Assert.assertNotNull(ioc22);
        Assert.assertNotNull(ioc22.getClass().getName());

        Ioc2 ioc23 = (Ioc2) factory.getBean("ioc2");
        Assert.assertNotNull(ioc23);
        Assert.assertNotNull(ioc23.getClass().getName());

        Ioc2 ioc24 = (Ioc2) factory.getBean("ioc2");
        Assert.assertNotNull(ioc24);
        Assert.assertNotNull(ioc24.getClass().getName());

        Ioc2 ioc25 = (Ioc2) factory.getBean("ioc2");
        Assert.assertNotNull(ioc25);
        Assert.assertNotNull(ioc25.getClass().getName());
    }

    @Test
    public void test9() {
        Ioc1 ioc21 = (Ioc1) factory.getBean("ioc1");
        Assert.assertNotNull(ioc21);
        Assert.assertNotNull(ioc21.getClass().getName());

        Ioc1 ioc22 = (Ioc1) factory.getBean("ioc1");
        Assert.assertNotNull(ioc22);
        Assert.assertNotNull(ioc22.getClass().getName());

        Ioc1 ioc23 = (Ioc1) factory.getBean("ioc1");
        Assert.assertNotNull(ioc23);
        Assert.assertNotNull(ioc23.getClass().getName());

        Ioc1 ioc24 = (Ioc1) factory.getBean("ioc1");
        Assert.assertNotNull(ioc24);
        Assert.assertNotNull(ioc24.getClass().getName());

        Ioc1 ioc25 = (Ioc1) factory.getBean("ioc1");
        Assert.assertNotNull(ioc25);
        Assert.assertNotNull(ioc25.getClass().getName());
    }

    @Test
    public void test10() {
        Ioc2 ioc2 = (Ioc2) factory.getBean("ioc2");
        Assert.assertNotNull(ioc2);
        Assert.assertNotNull(ioc2.getIoc1());
        Assert.assertNotNull(ioc2.getFather());
        Assert.assertNotNull(ioc2.getPeople());
        Assert.assertNotNull(ioc2.getUser());
        Assert.assertNotNull(ioc2.getIoc1().getIoc());
        Assert.assertNotNull(ioc2.getIoc1().getUser());
        Assert.assertNotNull(ioc2.getIoc1().getPeople());
        Assert.assertNotNull(ioc2.getIoc1().getFather());
    }

    @Test
    public void test11() {
        Ioc1 ioc1 = (Ioc1) factory.getBean("ioc1");
        Assert.assertNotNull(ioc1);
        Assert.assertNotNull(ioc1.getFather());
        Assert.assertNotNull(ioc1.getPeople());
        Assert.assertNotNull(ioc1.getUser());

        Ioc1 ioc2 = (Ioc1) factory.getBean("ioc1");
        Assert.assertNotNull(ioc2);
        Assert.assertNotNull(ioc2.getFather());
        Assert.assertNotNull(ioc2.getPeople());
        Assert.assertNotNull(ioc2.getUser());

        System.out.println(ioc1);
        System.out.println(ioc1.getFather());
        System.out.println(ioc1.getPeople());
        System.out.println(ioc1.getUser());
        System.out.println();

        System.out.println(ioc2);
        System.out.println(ioc2.getFather());
        System.out.println(ioc2.getPeople());
        System.out.println(ioc2.getUser());
        System.out.println();

        Ioc1 ioc4 = (Ioc1) factory.getBean("ioc1");
        Assert.assertNotNull(ioc4);
        Assert.assertNotNull(ioc4.getFather());
        Assert.assertNotNull(ioc4.getPeople());
        Assert.assertNotNull(ioc4.getUser());
    }
}
