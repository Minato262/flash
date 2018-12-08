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
package org.flashframework.aop.interceptor;

import java.lang.reflect.Method;

/**
 * @author kay
 * @version v2.0
 */
public class InterceptorImpl implements Interceptor {

    @Override
    public void begin(Method methodTarget, Object[] args) {

    }

    @Override
    public boolean filter(Method methodTarget, Object[] args) {
        return true;
    }

    @Override
    public void before(Method methodTarget, Object[] args) {
        System.out.println("before");
    }

    @Override
    public Object around(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("around");
        return null;
    }

    @Override
    public void after(Method methodTarget, Object[] args) {
        System.out.println("after");
    }

    @Override
    public void error(Method methodTarget, Object[] args, Throwable e) {

    }

    @Override
    public void end(Method methodTarget, Object[] args) {

    }
}
