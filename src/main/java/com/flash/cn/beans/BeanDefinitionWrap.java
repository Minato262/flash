/*
 * Copyright 2017-2017 the original author or authors.
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
package com.flash.cn.beans;

/**
 * Bean Definition 包装类
 *
 * @author kay
 * @version v1.0
 */
final class BeanDefinitionWrap {
    private boolean hasAutowired;
    private Object object;

    public BeanDefinitionWrap(boolean hasAutowired, Object object) {
        this.hasAutowired = hasAutowired;
        this.object = object;
    }

    public boolean isHasAutowired() {
        return hasAutowired;
    }

    public Object getObject() {
        return object;
    }
}
