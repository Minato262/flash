/*
 * Copyright 2017-2019 the original author or authors.
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
package org.flashframework.aop;

import org.flashframework.core.NestedRuntimeException;

/**
 * 切面基础异常
 *
 * @author kay
 * @version v2.0
 */
public abstract class AspectRuntimeException extends NestedRuntimeException {
    private static final long serialVersionUID = -6357450104880192887L;

    /**
     * 默认构造器
     */
    public AspectRuntimeException() {
        super();
    }

    /**
     * 带有错误信息的构造器
     *
     * @param message 错误信息
     */
    public AspectRuntimeException(String message) {
        super(message);
    }

    /**
     * 带有堆栈异常信息的构造器
     *
     * @param cause 堆栈异常信息
     */
    public AspectRuntimeException(Throwable cause) {
        super(cause);
    }
}
