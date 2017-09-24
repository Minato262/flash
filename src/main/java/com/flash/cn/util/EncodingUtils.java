package com.flash.cn.util;

import com.flash.cn.core.ClassPathResourceException;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 编码工具类。
 *
 * @author kay
 * @version v1.0
 */
public class EncodingUtils {

    /**
     * 编码类型：UTF-8
     */
    public static final String ENCODING_CODE_UTF8 = "UTF-8";

    /**
     * 转译成 uft-8 类型字符串
     *
     * @param source 来源
     * @return 转译后的字符串
     */
    public static String decode(String source) {
        try {
            return URLDecoder.decode(source, ENCODING_CODE_UTF8);
        }
        catch (UnsupportedEncodingException e) {
            throw new ClassPathResourceException();
        }
    }
}
