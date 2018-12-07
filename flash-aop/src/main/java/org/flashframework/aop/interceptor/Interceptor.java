package org.flashframework.aop.interceptor;

/**
 * @author kay
 * @version v2.0
 */
public interface Interceptor {

    void after();

    void afterReturning();

    void afterThrowing();

    void around();

    void before();
}
