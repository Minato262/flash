package org.flashframework.aop.interceptor;

/**
 * @author kay
 * @version v2.0
 */
public class InterceptorImpl implements Interceptor {

    @Override
    public void after() {
        System.out.println("after");
    }

    @Override
    public void afterReturning() {

    }

    @Override
    public void afterThrowing() {

    }

    @Override
    public void around() {

    }

    @Override
    public void before() {
        System.out.println("before");
    }
}
