package com.flash.cn.beans;

import com.flash.cn.NestedRuntimeException;

/**
 * @author kay
 * @version v1.0
 */
public class BeanException extends NestedRuntimeException {

    /**
     *
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
