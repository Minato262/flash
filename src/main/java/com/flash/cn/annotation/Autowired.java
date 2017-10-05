package com.flash.cn.annotation;

import java.lang.annotation.*;

/**
 * Autowired 注释，它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作
 * 通过 @Autowired 的使用来消除 set ，get方法
 *
 * @author kay
 * @version v1.0
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface Autowired {
}
