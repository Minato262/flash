package com.flash.cn.beans;

/**
 * Bean 创建失败异常
 *
 * @author kay
 * @version v1.0
 */
class BeanCreateFailureException extends BeanException {

    /**
     * 带有错误信息的构造器
     *
     * @param message 错误信息
     */
    public BeanCreateFailureException(String message) {
        super(message);
    }

    /**
     * 带有堆栈异常信息的构造器
     *
     * @param cause 堆栈异常信息
     */
    public BeanCreateFailureException(Throwable cause) {
        super(cause);
    }
}
