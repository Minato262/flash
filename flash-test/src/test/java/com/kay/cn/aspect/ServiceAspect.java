package com.kay.cn.aspect;

import org.flashframework.aop.annotation.*;
import org.flashframework.context.annotation.Component;

@Aspect
@Component
public class ServiceAspect {

    @After(value = "t", argNames = "t")
    public void afterTest() {
    }

    @AfterReturning()
    public void afterReturningTest() {
    }

    @AfterThrowing()
    public void afterThrowingTest() {
    }

    @Around(value = "t1", argNames = "t1")
    public void aroundTest() {
        //
    }

    @Before(value = "t2", argNames = "t2")
    public void beforeTest() {
        System.out.println("beforeTest");
    }

    @Pointcut(value = "t3", argNames = "t3")
    public void pointcutTest() {
    }
}
