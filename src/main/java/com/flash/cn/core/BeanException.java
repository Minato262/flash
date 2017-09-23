package com.flash.cn.core;

import com.flash.cn.NestedRuntimeException;

/**
 * @author kay
 * @version v1.0
 */
public abstract class BeanException extends NestedRuntimeException {

    /**
     * Bean 异常，默认构造器。
     */
    public BeanException() {
        super();
    }

    /**
     *
     * @param cause
     */
    public BeanException(Throwable cause) {
        super(cause);
    }

    /**
     * Bean 异常，默认构造器。
     */
    public BeanException(String message, Throwable cause) {
        super(message, cause);
    }
}
