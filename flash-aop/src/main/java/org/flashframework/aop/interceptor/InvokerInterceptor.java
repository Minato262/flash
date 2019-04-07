package org.flashframework.aop.interceptor;

import org.flashframework.aop.handle.method.MethodInterceptor;

import java.lang.reflect.Method;

public class InvokerInterceptor implements MethodInterceptor {

    public InvokerInterceptor() {
        //
    }

    @Override
    public Object target(Method methodTarget, Object[] args) {
        return null;
    }
}
