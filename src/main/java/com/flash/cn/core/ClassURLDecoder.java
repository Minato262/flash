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
package com.flash.cn.core;

import com.flash.cn.Encoding;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Class 编码工具类
 *
 * @author kay
 * @version v1.0
 */
class ClassURLDecoder {

    /**
     * 转译成 uft-8 类型字符串
     *
     * @param source 来源
     * @return 转译后的字符串
     * @throw ClassPathResourceException 不支持 UTF-8 编码
     */
    public static String decode(String source) {
        try {
            return URLDecoder.decode(source, Encoding.UTF8.getCode());
        }
        catch (UnsupportedEncodingException e) {
            throw new ClassPathResourceException("不支持 UTF-8 编码");
        }
    }
}
