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
