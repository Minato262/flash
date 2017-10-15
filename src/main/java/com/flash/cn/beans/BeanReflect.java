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

import com.flash.cn.util.Assert;

/**
 * 反射相关工具类
 *
 * @author kay
 * @version v1.0
 */
public class BeanReflect {

    /**
     * 根据对象的路径，反射生成新的对象
     *
     * @param name 反射对象的对象路径
     * @param <T>  弱类型转成指定强类型
     * @return 生成的新的对象
     * @throw BeanCreateFailureException 如果对象新建失败
     */
    @SuppressWarnings("unchecked")
    public static <T> T newInstance(String name) {
        Assert.isNotEmpty(name);
        try {
            Class<T> clazz = (Class<T>) Class.forName(name);
            return clazz.newInstance();
        }
        catch (Exception e) {
            throw new BeanCreateFailureException(e);
        }
    }
}
