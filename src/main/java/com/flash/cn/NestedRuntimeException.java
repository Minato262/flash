package com.flash.cn;

/**
 * Nested Runtime Exception.
 *
 * @author kay
 * @version v1.0
 */
public abstract class NestedRuntimeException extends RuntimeException {

    /**
     * Nested Runtime Exception.
     */
    public NestedRuntimeException() {
        super();
    }

    /**
     * Nested Runtime Exception.
     *
     * @param cause 异常
     */
    public NestedRuntimeException(Throwable cause) {
        super(cause);
    }

    /**
     * Bean 异常，默认构造器。
     */
    public NestedRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
