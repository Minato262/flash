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
package org.flashframework.aop.handler;

import org.flashframework.aop.interceptor.Interceptor;
import org.flashframework.aop.interceptor.InterceptorImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author kay
 * @version v2.0
 */
public class AspectHandler implements InvocationHandler {

    private Object obj;

    private Interceptor interceptor = new InterceptorImpl();

    public AspectHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        interceptor.begin(method, args);
        try {
            if (interceptor.filter(method, args)) {
                Object result;
                interceptor.before(method, args);
                result = method.invoke(obj, args);
                interceptor.after(method, args);
                return result;
            }
            else {
                return interceptor.around(proxy, obj, method, args);
            }
        }
        catch (Exception e) {
            interceptor.error(method, args, e);
            throw e;
        }
        finally {
            interceptor.end(method, args);
        }
    }
}
