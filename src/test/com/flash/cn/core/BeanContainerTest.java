package com.flash.cn.core;

import org.junit.Test;

/**
 * @author kay
 * @version v1.0
 */
public class BeanContainerTest {

    @Test
    public void test() {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
    }

    private class MyThread extends Thread {

        @Override
        public void run() {
            BeanContainer container = BeanContainer.getInstance();
            container.init("com.flash.cn");
            container.println();
        }
    }
}


