package org.flashframework.aop.interceptor;

import org.flashframework.aop.method.MethodInterceptor;

import java.lang.reflect.Method;

public class InvokerInterceptor implements MethodInterceptor {

    public InvokerInterceptor() {
        //
    }

    @Override
    public Object target(Method method, Object[] args) {
        System.out.println(method);
        return null;
    }
}
