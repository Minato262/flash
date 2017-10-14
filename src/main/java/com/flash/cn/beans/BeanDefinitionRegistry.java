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
import com.flash.cn.annotation.Lazy;
import com.flash.cn.annotation.Scope;
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

    private void loadRepository(Map<String, Class> registryTable) {
        for (Map.Entry<String, Class> entry : registryTable.entrySet()) {
            Scope scope = (Scope) entry.getValue().getAnnotation(Scope.class);
            if (scope != null && BeanContainerMode.FLASH_PROPERTIES_PROTOTYPE.equals(scope.value())) {
                container.put(entry.getKey(), entry.getValue());
                continue;
            }
            Lazy lazy = (Lazy) entry.getValue().getAnnotation(Lazy.class);
            if (lazy != null) {
                container.put(entry.getKey(), entry.getValue());
                continue;
            }
            Object object = BeanReflect.newInstance(entry.getValue().getName());
            container.put(entry.getKey(), object);
        }
    }

    /**
     * 根据容器中的key获取对象，载入方法注释
     *
     * @throw BeanCreateFailureException Bean 设置失败
     */
    private void loadAutowired(Map<String, Class> registryTable) {
        for (Map.Entry<String, Class> entry : registryTable.entrySet()) {
            Object object = container.get(entry.getKey());
            BeanDefinitionWrap wrap = loadAutowired(object);
            if (wrap.isHasAutowired()) {
                container.put(entry.getKey(), wrap.getData());
            }
        }
    }

    private Object getValue(String key){
        Object object = container.get(key);
        if (object instanceof Class) {
            Class clazz = (Class) object;
            object = BeanReflect.newInstance(clazz.getName());
            container.put(key, object);
        }
        return container.get(key);
    }

    private BeanDefinitionWrap<Object> loadAutowired(Object object) {
        boolean hasAutowired = false;
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Autowired annotation = field.getAnnotation(Autowired.class);
            if (annotation != null) {
                try {
                    field.set(object, getValue(field.getName()));
                }
                catch (IllegalAccessException e) {
                    throw new BeanCreateFailureException(e);
                }
                hasAutowired = true;
            }
        }
        return new BeanDefinitionWrap<Object>(hasAutowired, object);
    }

    @Override
    public void refresh() {
        table.refresh();

        Map<String, Class> registryTable = table.getTable();
        loadRepository(registryTable);
        loadAutowired(registryTable);
    }
}
