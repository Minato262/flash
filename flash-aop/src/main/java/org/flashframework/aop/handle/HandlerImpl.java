package org.flashframework.aop.handle;

import lombok.Data;
import org.flashframework.aop.annotation.*;

@Data
public class HandlerImpl {

    private Aspect aspect;

    private Before before;

    private After after;

    private Around around;

    private Pointcut pointcut;

    private AfterReturning afterReturning;

    private AfterThrowing afterThrowing;
}
