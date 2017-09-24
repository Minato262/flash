package com.flash.cn;

import com.flash.cn.context.ApplicationContextFactory;
import com.flash.cn.beans.BeanFactory;
import com.flash.cn.core.ClassUtils;
import com.flash.cn.core.factory.Ioc;
import com.flash.cn.core.factory.People;
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
        People people = factory.getBean("2");
        assert people != null;
        System.out.println(people);
        System.out.println(people.getAge());
        System.out.println(people.getName());

        people.setAge(1);
        people.setName("name");

        People people1 = factory.getBean("2");
        assert people1 != null;
        System.out.println(people1);
        System.out.println(people1.getAge());
        System.out.println(people1.getName());
    }

    @Test
    public void test1() {
        BeanFactory factory = new ApplicationContextFactory();
        People people = factory.getBean("people");
        System.out.println(people);
        System.out.println(people.getAge());
        System.out.println(people.getName());

        people.setAge(2);

        BeanFactory factory1 = new ApplicationContextFactory();
        People people1 = factory1.getBean("people");
        System.out.println(people1);
        System.out.println(people1.getAge());
        System.out.println(people1.getName());
    }

    @Test
    public void test2() throws ClassNotFoundException {
        System.out.println(Arrays.toString(Class.forName("com.flash.cn.core.factory.Ioc").getDeclaredFields()));
    }

    @Test
    public void test3() {
        Ioc ioc = factory.getBean("ioc");
        System.out.println(ioc);
        System.out.println(ioc.getFather());
        System.out.println(ioc.getPeople());
        System.out.println(ioc.getUser());
    }

    @Test
    public void test4() throws ClassNotFoundException {
        //Object object = ClassUtils.newInstance("com.flash.cn.core.factory.Ioc");
        //System.out.println(Arrays.toString(object.getClass().getDeclaredFields()));
    }

    @Test
    public void test5() {
        System.out.println(factory.getBean("1"));
    }
}
