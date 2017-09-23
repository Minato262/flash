package com.flash.cn.util;

import java.io.*;
import java.util.Properties;

/**
 * 配置工具类。
 *
 * @author kay
 * @version v1.0
 */
public final class PropertiesUtils {

    private static String loadProperties(String propertyPath, String propertyName) throws IOException {
        Properties prop = new Properties();
        InputStream in = null;
        try {
            in = Object.class.getResourceAsStream(propertyPath);
            prop.load(in);
            for (String key : prop.stringPropertyNames()) {
                if (propertyName.equals(key)) {
                    return prop.getProperty(key);
                }
            }
            return "";
        }
        finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public static String load(String propertyPath, String propertyName) {
        try {
            return loadProperties(propertyPath, propertyName);
        }
        catch (IOException e) {
            return "";
        }
    }
}
