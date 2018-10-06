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
package org.flashframework.core.properties;

import org.flashframework.core.CoreRuntimeException;

/**
 * 配置常用异常
 *
 * @author kay
 * @version v2.0
 */
class PropertiesRuntimeException extends CoreRuntimeException {
    private static final long serialVersionUID = -5679745332252139166L;

    /**
     * 默认构造器，异常信息没有进行初始化
     */
    PropertiesRuntimeException() {
        super();
    }
}
