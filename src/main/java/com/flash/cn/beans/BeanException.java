package com.flash.cn.beans;

import com.flash.cn.NestedRuntimeException;

/**
 * @author kay
 * @version v1.0
 */
public class BeanException extends NestedRuntimeException {

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
}
