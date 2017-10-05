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
 * 字符串工具
 *
 * @author kay
 * @version v1.0
 */
public class StringUtils {

    /**
     * 判断字符串是否为空
     *
     * @param str 字符串
     * @return 是否为空
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    /**
     * 在class 类全路径名中获取相应的类名
     *
     * @param name class 类全路径名
     * @return 获取的相应的类名
     */
    public static String getLowerCase(String name) {
        int i = name.lastIndexOf(".");
        return name.substring(i + 1, name.length());
    }

    /**
     * 字符串首字母小写
     *
     * @param str 需要首字母小写的字符串
     * @return 处理后的字符串
     */
    public static String toLowerCaseFirstOne(String str) {
        if (Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        else {
            return (new StringBuilder()).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).toString();
        }
    }
}
