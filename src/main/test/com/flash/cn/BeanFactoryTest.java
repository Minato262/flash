package com.flash.cn;

import com.flash.cn.factory.People;
import org.junit.Test;

/**
 * {@link ApplicationContextFactory} test.
 *
 * @author kay
 * @version v1.0
 */
public class BeanFactoryTest {

    @Test
    public void test() {
        BeanFactory factory = new ApplicationContextFactory();
        People people = factory.getBean("com.flash.cn.factory.People");
        System.out.println(people);
        System.out.println(people.getAge());
        System.out.println(people.getName());

        people.setAge(1);
        people.setName("name");

        People people1 = factory.getBean("com.flash.cn.factory.People");
        System.out.println(people1);
        System.out.println(people1.getAge());
        System.out.println(people1.getName());
    }
}
