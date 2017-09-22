package com.flash.cn.util;

import java.io.*;
import java.util.Properties;

/**
 * @author kay
 * @version v1.0
 */
public final class PropertiesUtils {

    private static String loadProperties(String name) throws IOException {
        Properties prop = new Properties();
        InputStream in = null;
        try {
            in = Object.class.getResourceAsStream(name);
            prop.load(in);
            for (String key : prop.stringPropertyNames()) {
                if ("packageName".equals(key)) {
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

    public static String load(String name) {
        try {
            return loadProperties(name);
        }
        catch (IOException e) {
            return "";
        }
    }
}
