/*
 * Copyright 2017-2017 the original author or authors.
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
package com.flash.cn.util;

/**
 * 容器模式
 *
 * @author kay
 * @version v1.0
 */
public enum ContainerMode {
    SINGLETON("singleton"), MULTIPLE("multiple");

    private static final String FLASH_PROPERTIES_MODE = "containerModes";

    private String mode;

    ContainerMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return this.mode;
    }

    /**
     * 判断容器模式，配置是否是单例模式
     *
     * @return 是否是单例模式
     */
    public boolean isSingleton() {
        return !ContainerMode.MULTIPLE.getMode().equals(this.mode);
    }

    /**
     * 获取容器配置模式
     *
     * @return 单例或者多例模式
     */
    public static ContainerMode getContainerModes() {
        String mode = new LoadProperties().load(FLASH_PROPERTIES_MODE);
        if (!ContainerMode.MULTIPLE.getMode().equals(mode)) {
            return ContainerMode.SINGLETON;
        }
        else {
            return ContainerMode.MULTIPLE;
        }
    }
}
