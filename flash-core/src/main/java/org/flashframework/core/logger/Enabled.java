/*
 * Copyright 2017-2019 the original author or authors.
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
package org.flashframework.core.logger;

/**
 * 日志配置是否启动配置常量
 *
 * @author kay
 * @version v2.0
 */
public enum Enabled {
    /**
     * 启动日志打印：是的
     */
    TRUE(true),

    /**
     * 启动日志打印：否
     */
    FALSE(false);

    private boolean enabled;

    Enabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public static boolean getEnabled(String str) {
        for (Enabled enabled : Enabled.values()) {
            if (enabled.toString().equalsIgnoreCase(str)) {
                return enabled.getEnabled();
            }
        }
        return Enabled.TRUE.getEnabled();
    }
}
