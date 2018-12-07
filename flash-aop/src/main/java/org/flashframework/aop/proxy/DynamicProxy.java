package org.flashframework.aop.proxy;

import org.flashframework.aop.interceptor.Interceptor;
import org.flashframework.aop.interceptor.InterceptorImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author kay
 * @version v2.0
 */
public class DynamicProxy implements InvocationHandler {

    private Object obj;

    private Interceptor interceptor = new InterceptorImpl();

    public Object bind(Object obj) {
        this.obj = obj;
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        interceptor.after();
        Object result = method.invoke(obj, args);
        interceptor.before();
        return result;
    }
}
