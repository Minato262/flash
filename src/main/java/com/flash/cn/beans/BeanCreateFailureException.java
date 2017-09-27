package com.flash.cn.beans;

/**
 * Bean Create Failure Exception.
 *
 * @author kay
 * @version v1.0
 */
public class BeanCreateFailureException extends BeanException {

    /**
     * 默认构造器
     *
     * @param message 错误信息
     */
    public BeanCreateFailureException(String message) {
        super(message);
    }

    /**
     * 带有堆栈异常信息的构造器。
     *
     * @param cause 堆栈异常信息
     */
    public BeanCreateFailureException(Throwable cause) {
        super(cause);
    }
}
