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
package com.flash.cn.beans;

import java.util.Map;

/**
 * Bean Definition 注册表接口
 *
 * @author kay
 * @version v1.0
 */
public interface BeanDefinitionTable extends Map<String, Class> {

    /**
     * 将扫描出的对象信息，放入注册表
     *
     * @param key   关键字
     * @param value 包含 Class 信息的对象值
     * @return Put 成功的 value 值
     * @throw BeanDefinitionConflictException 如果 Bean Definition 相冲突
     */
    Class put(String key, Class value);
}
