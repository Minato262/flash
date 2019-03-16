package com.kay.cn;

import com.kay.cn.factory.Father;
import org.flashframework.beans.factory.BeanFactory;
import org.flashframework.context.factory.ApplicationContextFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnnotationTest {

    protected BeanFactory factory;

    @Before
    public void init() {
        factory = new ApplicationContextFactory();
    }

    @Test
    public void test() {
        Father father = (Father) factory.getBean("father");
        Assert.assertNotNull(father);
    }
}
