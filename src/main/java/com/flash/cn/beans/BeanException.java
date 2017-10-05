package com.flash.cn.beans;

import com.flash.cn.NestedRuntimeException;

/**
 * Bean 相关的异常
 *
 * @author kay
 * @version v1.0
 */
abstract class BeanException extends NestedRuntimeException {

    /**
     * 带有错误信息的构造器
     *
     * @param message 错误信息
     */
    public BeanException(String message) {
        super(message);
    }

    /**
     * 带有堆栈异常信息的构造器
     *
     * @param cause 堆栈异常信息
     */
    public BeanException(Throwable cause) {
        super(cause);
    }
}
