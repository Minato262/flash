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
package org.flashframework.core.util;

import org.flashframework.core.Unicode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 解码常用工具类
 *
 * @author kay
 * @version v1.0
 */
public class Decoder {

    /**
     * 转译成 uft-8 类型字符串
     *
     * @param source 来源（一定不能为空）
     * @return 转译后的字符串
     * @throws IllegalArgumentException 如果字符串为空
     */
    public static String decode(String source) {
        Assert.isNotEmpty(source);
        try {
            return URLDecoder.decode(source, Unicode.UTF_8.getCode());
        }
        catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
