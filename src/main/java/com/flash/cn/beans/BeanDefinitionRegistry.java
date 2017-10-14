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

import com.flash.cn.annotation.Autowired;
import com.flash.cn.util.Assert;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author kay
 * @version v1.0
 */
public class BeanDefinitionRegistry implements BeanDefinition {

    private BeanContainer container;

    private BeanDefinitionTable table;

    public BeanDefinitionRegistry(BeanDefinitionTable table, BeanContainer container) {
        Assert.isNotNull(table);
        Assert.isNotNull(container);
        this.table = table;
        this.container = container;
    }

    private void registry(){
        Map<String, Class> registryTable = table.getTable();
        loadAnnotation(registryTable);
    }

    private void loadAnnotation(Map<String, Class> registryTable){

    }

    /**
     * 根据容器中的key获取对象，载入方法注释
     *
     * @param container 需要注册的容器
     * @param key       容器中的key
     * @throw BeanCreateFailureException Bean 设置失败
     */
    private BeanDefinitionWrap loadAutowired(Map<String, Object> container, String key) {
        boolean hasAutowired = false;
        Object object = container.get(key);
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Autowired annotation = field.getAnnotation(Autowired.class);
            if (annotation != null) {
                try {
                    field.set(object, container.get(field.getName()));
                }
                catch (IllegalAccessException e) {
                    throw new BeanCreateFailureException(e);
                }
                hasAutowired = true;
            }
        }
        return new BeanDefinitionWrap<Object>(hasAutowired, object);
    }

    /**
     * 遍历容器，载入方法注释
     *
     * @param container 需要遍历载入的容器
     * @throw BeanCreateFailureException Bean 设置失败
     */
    private void loadAutowired(Map<String, Object> container) {
        for (Map.Entry<String, Object> entry : container.entrySet()) {
            BeanDefinitionWrap warp = loadAutowired(container, entry.getKey());
            if (warp.isHasAutowired()) {
                container.put(entry.getKey(), warp.getData());
            }
        }
    }

    @Override
    public void refresh() {
        table.refresh();
        registry();
    }
}
