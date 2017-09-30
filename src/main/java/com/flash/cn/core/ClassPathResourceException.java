package com.flash.cn.core;

import com.flash.cn.NestedRuntimeException;

/**
 * @author kay
 * @version v1.0
 */
public class ClassPathResourceException extends NestedRuntimeException {

    /**
     * 带有堆栈异常信息的构造器。
     *
     * @param cause 堆栈信息
     */
    public ClassPathResourceException(Throwable cause) {
        super(cause);
    }
}
