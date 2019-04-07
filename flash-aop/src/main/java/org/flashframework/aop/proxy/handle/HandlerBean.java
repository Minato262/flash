package org.flashframework.aop.proxy.handle;

import lombok.Data;
import org.flashframework.aop.annotation.*;

@Data
public class HandlerBean {

    private Aspect aspect;

    private Before before;

    private After after;

    private Around around;

    private Pointcut pointcut;

    private AfterReturning afterReturning;

    private AfterThrowing afterThrowing;

    private Class clazz;
}
