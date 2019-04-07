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
import org.flashframework.aop.annotation.AopAnno;
import org.flashframework.aop.AspectTable;
import org.flashframework.aop.AspectTableAware;
import org.flashframework.aop.proxy.handle.HandlerBean;
import org.flashframework.aop.method.MethodInterceptor;

import java.lang.reflect.Method;

import static org.flashframework.aop.annotation.AopAnno.*;

/**
 * Aop 拦截器，用于拦截 方法
 *
 * @author kay
 * @version v2.0
 */
@Slf4j
public class InterceptorImpl implements Interceptor {

    /**
     * Aop 切点注册表
     */
    private AspectTable table = AspectTableAware.getInstance();

    private MethodInterceptor interceptor = new InvokerInterceptor();

    private String packageUrl;

    public InterceptorImpl(Object obj) {
        init(obj);
    }

    private void init(Object obj) {
        packageUrl = getPackageUrl(obj.getClass());
        System.out.println(packageUrl);

        for (Object key : table.keySet()) {
            HandlerBean bean = (HandlerBean) table.get(key);
            System.out.println(bean);
        }
    }

    /**
     * 获取 对象 的类路径
     *
     * @param clazz 对象信息
     * @return 类路径
     */
    private String getPackageUrl(Class clazz) {
        return clazz.getName().substring(0, clazz.getName().lastIndexOf("."));
    }

    private boolean isPointcut() {
        return true;
    }

    private boolean isPointcut(AopAnno aopAnno) {
        if (BEFORE == aopAnno) {
            for (Object key : table.keySet()) {
                HandlerBean bean = (HandlerBean) table.get(key);
                if (bean.getBefore().value().contains(packageUrl)) {
                    return true;
                }
            }
        }
        else if (AROUND == aopAnno) {
            for (Object key : table.keySet()) {
                HandlerBean bean = (HandlerBean) table.get(key);
                if (bean.getAround().value().contains(packageUrl)) {
                    return true;
                }
            }
        }
        else if (AFTER == aopAnno) {
            for (Object key : table.keySet()) {
                HandlerBean bean = (HandlerBean) table.get(key);
                if (bean.getAfter().value().contains(packageUrl)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 切面，在进入方法时执行
     *
     * @param methodTarget 目标方法
     * @param args         目标参数数组
     */
    @Override
    public void begin(Method methodTarget, Object[] args) {
        if (isPointcut()) {
            interceptor.target(methodTarget, args);
        }
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
        if (isPointcut(BEFORE)) {
            interceptor.target(methodTarget, args);
        }
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
//        if (isPointcut(AROUND)) {
//
//        }
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
        if (isPointcut(AFTER)) {
            interceptor.target(methodTarget, args);
        }
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
        if (isPointcut(AFTER_THROWING)) {
            throw new Throwable();
        }
    }

    /**
     * 切面，用于设置拦截过滤条件
     *
     * @param methodTarget 目标方法
     * @param args         目标方法
     */
    @Override
    public void end(Method methodTarget, Object[] args) {
        if (isPointcut()) {
            interceptor.target(methodTarget, args);
        }
    }
}
