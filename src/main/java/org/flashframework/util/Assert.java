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
package org.flashframework.util;

/**
 * 断言工具类，使用断言可以简化方法入参检测的代码，也可以用作程序探针
 *
 * @author kay
 * @version v1.0
 */
public class Assert {

    /**
     * 判断对象不能为null，当对象为null时，会抛出异常
     *
     * @param object 需要判断的对象
     * @throws IllegalArgumentException 如果字符串为null
     */
    public static void isNotNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("the object must be not null!");
        }
    }

    /**
     * 判断字符串不能为空，当字符串为空时，会抛出异常
     *
     * @param str 需要判断的字符串
     * @throws IllegalArgumentException 如果字符串为空
     */
    public static void isNotEmpty(String str) {
        if (str == null || "".equals(str)) {
            throw new IllegalArgumentException("the string must be not empty!");
        }
    }
}
