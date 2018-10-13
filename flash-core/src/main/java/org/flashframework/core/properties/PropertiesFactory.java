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
package org.flashframework.core.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 配置载入工具类
 *
 * @author kay
 * @version v2.0
 */
public class PropertiesFactory {

    /**
     * 载入配置，获取 Properties 配置值，如果配置项不存在，则返回为空
     *
     * @param propertyPath 配置路径
     * @return 获取 Properties 配置值
     */
    public static Properties load(String propertyPath) {
        try {
            return loadProperties(propertyPath);
        }
        catch (IOException e) {
            return new Properties();
        }
    }

    /**
     * 载入配置，获取 Properties 配置值，如果配置项不存在，则返回为空
     *
     * @param propertyPath 配置路径
     * @return 获取 Properties 配置值
     * @throws IOException 如果 I/O 异常
     */
    private static Properties loadProperties(String propertyPath) throws IOException {
        InputStream in = Object.class.getResourceAsStream(propertyPath);
        try {
            Properties prop = new Properties();
            prop.load(in);
            return prop;
        }
        finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
