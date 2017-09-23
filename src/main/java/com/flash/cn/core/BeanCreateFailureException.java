package com.flash.cn.core;

/**
 * Bean Create Failure Exception.
 *
 * @author kay
 * @version v1.0
 */
public class BeanCreateFailureException extends BeanException {

    /**
     * @param cause
     */
    public BeanCreateFailureException(Throwable cause) {
        super(cause);
    }
}
