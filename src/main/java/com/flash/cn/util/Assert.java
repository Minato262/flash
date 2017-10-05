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
