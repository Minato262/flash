/*
 * Copyright 2017-2019 the original author or authors.
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

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;

/**
 * @author kay
 * @version v2.0
 */
@Slf4j
public class InterceptorImpl implements Interceptor {

    /**
     * 切面，在进入方法时执行
     *
     * @param methodTarget 目标方法
     * @param args         目标参数数组
     */
    @Override
    public void begin(Method methodTarget, Object[] args) {

    }

    /**
     * 切面，用于设置拦截过滤条件
     *
     * @param methodTarget 目标方法
     * @param args         目标参数数组
     * @return 是否拦截成功
     */
    @Override
    public boolean filter(Method methodTarget, Object[] args) {
        return true;
    }

    /**
     * 切面，在目标方法调用前执行
     *
     * @param methodTarget 目标方法
     * @param args         目标参数数组
     */
    @Override
    public void before(Method methodTarget, Object[] args) {
        System.out.println("before");
    }

    /**
     * 切面，用于设置拦截过滤条件
     *
     * @param proxy  对象代理
     * @param target 对象
     * @param method 目标方法
     * @param args   目标参数数组
     * @return 方法结果返回
     */
    @Override
    public Object around(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("around");
        return null;
    }

    /**
     * 切面，在目标方法调用后执行
     *
     * @param methodTarget 目标方法
     * @param args         目标参数数组
     */
    @Override
    public void after(Method methodTarget, Object[] args) {
        System.out.println("after");
    }

    /**
     * 切面，用于设置拦截过滤条件
     *
     * @param methodTarget 目标方法
     * @param args         目标参数数组
     * @param e            异常
     * @throws Throwable 抛出异常
     */
    @Override
    public void error(Method methodTarget, Object[] args, Throwable e) throws Throwable {
        throw new Throwable();
    }

    /**
     * 切面，用于设置拦截过滤条件
     *
     * @param methodTarget 目标方法
     * @param args         目标方法
     */
    @Override
    public void end(Method methodTarget, Object[] args) {

    }
}
