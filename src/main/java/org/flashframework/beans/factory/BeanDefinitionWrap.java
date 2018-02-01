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
package org.flashframework.beans.factory;

import org.flashframework.util.Assert;

/**
 * 带有是否有方法注解和私有类载入的对象的 Bean Definition 包装类
 *
 * @author kay
 * @version v1.0
 */
final class BeanDefinitionWrap<T> {
    private boolean hasAutowired;
    private T date;

    /**
     * 带有是否有方法注解和私有类载入的对象的构造器
     *
     * @param hasAutowired 是否有方法注解
     * @param date         私有类载入的对象（一定不能为null）
     * @throws IllegalArgumentException 如果字符串为null
     */
    public BeanDefinitionWrap(boolean hasAutowired, T date) {
        Assert.isNotNull(date);
        this.hasAutowired = hasAutowired;
        this.date = date;
    }

    /**
     * 判断是否有方法注解
     *
     * @return 是否有方法注解
     */
    public boolean isHasAutowired() {
        return hasAutowired;
    }

    /**
     * 私有类载入的对象
     *
     * @return 私有类载入的对象
     */
    public T getData() {
        return date;
    }
}
