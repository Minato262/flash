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

import com.flash.cn.annotation.Controller;
import com.flash.cn.annotation.Repository;
import com.flash.cn.annotation.Service;
import com.flash.cn.util.Assert;
import com.flash.cn.util.StringUtils;

/**
 * 只是一个工具类，主要作用是载入类注解
 *
 * @author kay
 * @version v1.0
 */
public class BeanDefinitionLoad extends BeanDefinitionTableContext {

    /**
     * 默认构造器
     */
    public BeanDefinitionLoad() {
        //
    }

    /**
     * 放入 Bean Definition 清单中
     *
     * @param clazz 注册对象内容
     * @throws BeanDefinitionConflictException 如果 Bean Definition 已经存在
     */
    private void put(Class clazz) {
        // 类注解载入 Bean 容器，容器会自动载入类名作为 key
        // Bean 会作为 key 的关键字，会使用左驼峰命名
        String lowerCase = StringUtils.getLowerCase(clazz.getName());
        String key = StringUtils.toLowerCaseFirstOne(lowerCase);
        super.put(key, clazz);
    }

    /**
     * 根据 Class，载入类注解信息
     *
     * @param clazz class 信息
     * @throws IllegalArgumentException        如果字符串为null
     * @throws BeanDefinitionConflictException 如果 Bean Definition 已经存在
     */
    public void load(Class clazz) {
        Assert.isNotNull(clazz);
        Repository annotation = (Repository) clazz.getAnnotation(Repository.class);
        if (annotation != null) {
            super.put(annotation.value(), clazz);
            return;
        }
        Service annotation1 = (Service) clazz.getAnnotation(Service.class);
        if (annotation1 != null) {
            super.put(annotation1.value(), clazz);
            return;
        }
        Controller annotation2 = (Controller) clazz.getAnnotation(Controller.class);
        if (annotation2 != null) {
            put(clazz);
        }
    }
}
