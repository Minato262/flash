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
package org.flashframework.aop.handle;

import org.flashframework.aop.AspectRuntimeException;

/**
 * Aop 切面处理器异常
 *
 * @author kay
 * @version v2.0
 */
public class AspectHandlerRuntimeException extends AspectRuntimeException {
    private static final long serialVersionUID = 6072726423404799710L;

    /**
     * 带有堆栈异常信息的构造器
     *
     * @param cause 堆栈异常信息
     */
    public AspectHandlerRuntimeException(Throwable cause) {
        super(cause);
    }
}
