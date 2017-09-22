package com.flash.cn;

import com.flash.cn.beans.ApplicationContextFactory;
import com.flash.cn.beans.BeanFactory;
import org.junit.Before;

/**
 * @author kay
 * @version v1.0
 */
public class BeforeTest {

    protected BeanFactory factory;

    @Before
    public void init() {
        factory = new ApplicationContextFactory();
        System.out.println("容器启动!");
    }
}
