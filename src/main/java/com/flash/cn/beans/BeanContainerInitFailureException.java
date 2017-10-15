package com.flash.cn.beans;

/**
 * Bean 容器初始化失败异常
 *
 * @author kay
 * @version v1.0
 */
public class BeanContainerInitFailureException extends BeanException {

    /**
     * 带有堆栈异常信息的构造器
     *
     * @param cause 堆栈异常信息
     */
    public BeanContainerInitFailureException(Throwable cause) {
        super(cause);
    }
}
