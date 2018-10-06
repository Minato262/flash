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

import org.flashframework.core.util.Assert;

import java.util.Properties;

/**
 * 配置常用工具
 *
 * @author kay
 * @version v2.0
 */
public class PropertiesFactory {

    private Properties prop;

    /**
     * 设置配置项
     *
     * @param prop 配置项
     */
    public void setProperties(Properties prop) {
        Assert.isNotNull(prop);
        this.prop = prop;
    }

    /**
     * 载入配置，按照配置关键字获取配置值
     *
     * @param propertyName 配置关键字
     * @return Properties 配置值
     */
    public String getProperties(String propertyName) {
        if (prop == null) {
            throw new PropertiesNotSettingException();
        }

        for (String key : prop.stringPropertyNames()) {
            if (propertyName.equals(key)) {
                return prop.getProperty(key);
            }
        }
        return "";
    }
}
