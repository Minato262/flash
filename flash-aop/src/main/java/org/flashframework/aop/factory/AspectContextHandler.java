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
package org.flashframework.aop.factory;

import org.flashframework.aop.annotation.*;
import org.flashframework.aop.handle.HandlerBean;
import org.flashframework.context.factory.ApplicationContextHandler;

import java.lang.reflect.Method;

/**
 * Aop 注解处理器
 *
 * @author kay
 * @version v2.0
 */
public class AspectContextHandler extends ApplicationContextHandler {

    /**
     * Aop 切点注册表
     */
    private AspectPointcutTable table = AspectPointcutTableAware.getInstance();

    /**
     * 根据 Class，载入类注解信息
     * <p>默认载入 Aspect 注解</p>
     *
     * @param clazz class 信息
     * @throws IllegalArgumentException 如果Class为null，则抛出异常
     */
    @Override
    public void load(Class clazz) {
        super.load(clazz);
        Aspect annotation = (Aspect) clazz.getAnnotation(Aspect.class);
        if (annotation != null) {
            String name = super.getSimpleName(clazz);

            HandlerBean bean = getHandler(clazz);
            table.put(name, bean);
        }
    }

    /**
     * 获取 Handler bean.
     *
     * @param clazz 对象 Class
     * @return Handler bean
     */
    private HandlerBean getHandler(Class clazz) {
        HandlerBean handler = new HandlerBean();
        handler.setClazz(clazz);

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            Before before = method.getAnnotation(Before.class);
            if (before != null) {
                handler.setBefore(before);
            }
            Around around = method.getAnnotation(Around.class);
            if (around != null) {
                handler.setAround(around);
            }
            After after = method.getAnnotation(After.class);
            if (after != null) {
                handler.setAfter(after);
            }
            Pointcut pointcut = method.getAnnotation(Pointcut.class);
            if (pointcut != null) {
                handler.setPointcut(pointcut);
            }
            AfterReturning afterReturning = method.getAnnotation(AfterReturning.class);
            if (afterReturning != null) {
                handler.setAfterReturning(afterReturning);
            }
            AfterThrowing afterThrowing = method.getAnnotation(AfterThrowing.class);
            if (afterThrowing != null) {
                handler.setAfterThrowing(afterThrowing);
            }
        }
        return handler;
    }
}
