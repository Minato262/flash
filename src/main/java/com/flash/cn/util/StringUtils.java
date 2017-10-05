package com.flash.cn.util;

/**
 * 字符串工具
 *
 * @author kay
 * @version v1.0
 */
public class StringUtils {

    public static String getLowerCase(String str) {
        int i = str.lastIndexOf(".");
        return str.substring(i + 1, str.length());
    }

    /**
     * 字符串首字母小写
     *
     * @param str 需要首字母小写的字符串
     * @return 处理后的字符串
     */
    public static String toLowerCaseFirstOne(String str) {
        Assert.isNotEmpty(str);
        if (Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        else {
            return (new StringBuilder()).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).toString();
        }
    }
}
