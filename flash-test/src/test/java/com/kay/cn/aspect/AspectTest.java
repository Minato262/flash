package com.kay.cn.aspect;

import org.flashframework.aop.annotation.*;
import org.flashframework.context.annotation.Component;

@Aspect
@Component
public class AspectTest {

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
    }

    @Before(value = "t2", argNames = "t2")
    public void beforeTest() {
    }

    @Pointcut(value = "t3", argNames = "t3")
    public void pointcutTest() {
    }
}
