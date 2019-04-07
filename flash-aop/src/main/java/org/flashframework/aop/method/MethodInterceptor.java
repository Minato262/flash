package org.flashframework.aop.method;

import java.lang.reflect.Method;

public interface MethodInterceptor {

    Object target(Method method, Object[] args);
}
