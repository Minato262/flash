package org.flashframework.aop.handle.method;

import org.flashframework.aop.annotation.Annotation;

import java.lang.reflect.Method;

public interface MethodInterceptor {

    Object target(Method methodTarget, Object[] args);
}
