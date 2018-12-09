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
package org.flashframework.aop.factory;

import org.flashframework.aop.AspectRuntimeException;

/**
 * Aop 切面未发现注册信息异常
 *
 * @author kay
 * @version v2.0
 */
public class AspectNotFindRuntimeException extends AspectRuntimeException {
    private static final long serialVersionUID = 1963297972764525083L;

    /**
     * 带有错误信息的构造器
     *
     * @param message 错误信息
     */
    public AspectNotFindRuntimeException(String message) {
        super(message);
    }
}
