package com.flash.cn;

/**
 * Nested Runtime Exception.
 *
 * @author kay
 * @version v1.0
 */
public class NestedRuntimeException extends RuntimeException {

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
}
