package com.flash.cn.beans;

/**
 * Bean 容器初始化失败异常
 *
 * @author kay
 * @version v1.0
 */
public class BeanContainerInitFailureException extends BeanException {

    public BeanContainerInitFailureException(Throwable cause) {
        super(cause);
    }
}
