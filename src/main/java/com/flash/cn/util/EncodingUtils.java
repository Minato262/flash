package com.flash.cn.util;

import com.flash.cn.core.ClassPathResourceException;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author kay
 * @version v1.0
 */
public final class EncodingUtils {

    /**
     * 转译成 uft-8 类型字符串
     *
     * @param source 来源
     * @return 转译后的字符串
     */
    public static String decode(String source) {
        try {
            return URLDecoder.decode(source, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            throw new ClassPathResourceException();
        }
    }
}
