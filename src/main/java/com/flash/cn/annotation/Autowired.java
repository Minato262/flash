package com.flash.cn.annotation;

import java.lang.annotation.*;

/**
 * @author kay
 * @version v1.0
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface Autowired {
}
