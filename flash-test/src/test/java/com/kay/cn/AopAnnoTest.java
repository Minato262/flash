package com.kay.cn;

import com.kay.cn.factory.Father;
import org.flashframework.aop.AspectContextFactory;
import org.flashframework.beans.factory.BeanFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AopAnnoTest {

    protected BeanFactory factory;

    @Before
    public void init() {
        factory = new AspectContextFactory();
    }

    @Test
    public void test() {
        Father father = (Father) factory.getBean("father");
        Assert.assertNotNull(father);

        father.getMobile();
    }
}
