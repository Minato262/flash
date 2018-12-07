/*
 * Copyright 2017-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flashframework.aop.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author kay
 * @version v2.0
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object business;

    private InterceptorImpl interceptor = new InterceptorImpl();

    /**
     * 　　 动态生成一个代理类对象，并绑定被代理类和代理处理器。
     *
     * 　　 @param business
     * 　　 @return 代理类对象
     */
    public Object bind(Object business) {
        this.business = business;
        return Proxy.newProxyInstance(business.getClass().getClassLoader(), business.getClass().getInterfaces(), this);
    }

    /**
     * 　　 代理需要调用的方法，并在该方法调用前后，先调用连接器的方法。
     *
     * 　　 @param proxy 代理类对象
     * 　　 @param method 被代理的接口方法
     * 　　 @param args 被代理接口方法的参数
     * 　　 @return 方法调用返回的结果
     * 　　 @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        interceptor.before();
        Object result = method.invoke(business, args);
        interceptor.after();
        return result;
    }
}
