/*
 * Copyright 2017-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flashframework;

/**
 * {@code NestedRuntimeException} 是整个框架的抽象非受检性异常
 * <p>
 *    它用于定义整个框架相关的异常的基础方法，并且将所有捕获到的受检性异常转换成了非受检性异常
 * </p>
 * <p>
 *    继承于她的异常包括有：
 *    <br>WebRuntimeException  用于定于 web  相关的抽象异常</br>
 *    <br>BeanRuntimeException 用于定于 bean 相关的抽象异常</br>
 *    <br>ResourceException    用于定于 资源  相关的抽象异常</br>
 * </p>
 *
 * @author kay
 * @version v1.0
 */
public abstract class NestedRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1;

    /*
     * 概述：
     *
     *    受检性异常与非受检性异常（也有翻译成 检查异常和非检查异常）。
     *
     *    受检性异常，其实是一种相对落后的异常结构，如果处理不好，他会导致系统的突然
     * 崩溃，从语言的角度来讲 Java 的使用者，不应该在程序没有提示的情况下突然崩溃。
     * 所以在接触这类异常时，都需要经过有效处理或通过重试以恢复正常状态。但很多时候，
     * 去捕获这类异常其实是毫无益处的。所以，从编程的代码结构以及可读性的角度来讲，都
     * 是推荐使用非受检性异常的。
     *
     *    而这里的设计目的，就是将整个框架内的异常全部转化为非受检性异常。
     */

    /**
     * 默认构造器，异常信息没有进行初始化
     */
    public NestedRuntimeException() {
        super();
    }

    /**
     * 带有错误信息的构造器
     *
     * @param message 错误信息
     */
    public NestedRuntimeException(String message) {
        super(message);
    }

    /**
     * 带有堆栈异常信息的构造器
     *
     * @param cause 堆栈信息
     */
    public NestedRuntimeException(Throwable cause) {
        super(cause);
    }
}
