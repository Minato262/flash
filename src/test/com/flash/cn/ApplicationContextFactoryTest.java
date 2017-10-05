package com.flash.cn;

import com.flash.cn.annotation.Autowired;
import com.flash.cn.annotation.Repository;
import com.flash.cn.core.factory.*;
import org.junit.Test;

/**
 * @author kay
 * @version v1.0
 */
@Repository("applicationContextFactoryTest")
public class ApplicationContextFactoryTest extends BeforeTest {

    @Autowired
    private Father father;

    @Autowired
    private People people;

    @Autowired
    private User user;

    @Test
    public void test() {
        ApplicationContextFactoryTest test = factory.getBean("applicationContextFactoryTest");
        System.out.println(test.father.getAge());
        System.out.println(test.people.getAge());
        System.out.println(test.user.getAge());
    }
}
