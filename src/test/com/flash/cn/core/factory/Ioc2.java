package com.flash.cn.core.factory;

import com.flash.cn.annotation.Autowired;
import com.flash.cn.annotation.Controller;
import com.flash.cn.context.ApplicationContext;
import com.flash.cn.context.ApplicationContextFactory;
import com.sun.xml.internal.bind.v2.ContextFactory;
import org.junit.Test;

/**
 * @author kay
 * @version v1.0
 */
@Controller
public class Ioc2 {

    @Autowired
    private Father father;

    @Autowired
    private People people;

    @Autowired
    private User user;

    @Autowired
    private Ioc1 ioc1;

    public Father getFather() {
        return father;
    }

    public People getPeople() {
        return people;
    }

    public User getUser() {
        return user;
    }

    public Ioc1 getIoc1() {
        return ioc1;
    }

    @Test
    public void test(){
        ApplicationContext factory = new ApplicationContextFactory();
        Ioc2 ioc2 = factory.getBean("ioc2");
        System.out.println(ioc2);
        System.out.println(ioc2.getFather());
        System.out.println(ioc2.getPeople());
        System.out.println(ioc2.getUser());
        System.out.println(ioc2.getIoc1());
        System.out.println(ioc2.getIoc1().getFather());
        System.out.println(ioc2.getIoc1().getPeople());
        System.out.println(ioc2.getIoc1().getUser());
        System.out.println(ioc2.getIoc1().getIoc());
        System.out.println(ioc2.getIoc1().getIoc().getUser());
        System.out.println(ioc2.getIoc1().getIoc().getPeople());
        System.out.println(ioc2.getIoc1().getIoc().getFather());
    }
}
