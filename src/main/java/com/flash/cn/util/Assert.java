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
package com.flash.cn.util;

/**
 * 断言工具类
 *
 * @author kay
 * @version v1.0
 */
public class Assert {

    /**
     * 断言，判断字符串不能为 null
     *
     * @param str 需要判断的字符串
     * @throw IllegalArgumentException 对象不能为空
     */
    public static void isNotEmpty(String str) {
        if (str == null || "".equals(str)) {
            throw new IllegalArgumentException("the str must be not empty!");
        }
    }
}
