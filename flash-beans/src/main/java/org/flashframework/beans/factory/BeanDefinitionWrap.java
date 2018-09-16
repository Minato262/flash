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

import org.flashframework.core.util.Assert;

import java.io.Serializable;

/**
 * 带有是否有方法注解和私有类载入的对象的 Bean Definition 包装类
 *
 * @author kay
 * @version v1.0
 * <T> data
 */
final class BeanDefinitionWrap<T> implements Serializable {
    private static final long serialVersionUID = -2145083312359080837L;

    private boolean isAutowired;
    private T data;

    /**
     * 默认构造器
     */
    BeanDefinitionWrap() {
        isAutowired = false;
        data = null;
    }

    /**
     * 带有是否有方法注解和私有类载入的对象的构造器
     *
     * @param isAutowired 是否有方法注解
     * @param data         私有类载入的对象（一定不能为null）
     * @throws IllegalArgumentException 如果载入对象为null
     */
    BeanDefinitionWrap(boolean isAutowired, T data) {
        Assert.isNotNull(data);
        this.isAutowired = isAutowired;
        this.data = data;
    }

    /**
     * 判断是否有方法注解
     *
     * @return 是否有方法注解
     */
    public boolean isHasAutowired() {
        return isAutowired;
    }

    /**
     * 私有类载入的对象
     *
     * @return 私有类载入的对象
     */
    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "BeanDefinitionWrap[isAutowired=" + isAutowired + ",data=" + data + "]";
    }
}
