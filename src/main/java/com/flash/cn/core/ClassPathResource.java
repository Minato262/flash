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
package com.flash.cn.core;

import com.flash.cn.util.LoadProperties;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 根据路径，获取 Class 资源
 *
 * @author kay
 * @version v1.0
 */
public class ClassPathResource {

    /** 根据配置获取配置的包名 */
    private static final String FLASH_PACKAGE_NAME = new LoadProperties().load("packageName");

    /**
     * 检测全部 Class 类集合
     *
     * @param packageName 包名称
     * @param packagePath 包路径
     * @param classes     Class 类集合
     */
    private void checkClasses(String packageName, String packagePath, List<Class<?>> classes) {
        File dir = new File(packagePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }

        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return (file.isDirectory()) || (file.getName().endsWith(".class"));
            }
        });

        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                checkClasses(packageName + "." + file.getName(), file.getAbsolutePath(), classes);
            }
            else {
                String className = file.getName().substring(0, file.getName().length() - 6);
                classes.add(ClassLoader.loadClass(packageName + "." + className));
            }
        }
    }

    /**
     * 获取到 Class 类集合
     *
     * @param urlElements url 入参
     * @param packageName 包名
     * @return Class 类集合
     */
    private List<Class<?>> getClasses(Enumeration<URL> urlElements, String packageName) {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        while (urlElements.hasMoreElements()) {
            URL url = urlElements.nextElement();
            String protocol = url.getProtocol();
            if ("file".equals(protocol)) {
                String filePath = ClassURLDecoder.decode(url.getFile());
                checkClasses(packageName, filePath, classes);
            }
        }
        return classes;
    }

    /**
     * 获取 Class 名称
     *
     * @return Class 类集合
     */
    public List<Class<?>> getClasses() {
        String packageDirName = FLASH_PACKAGE_NAME.replace('.', '/');
        Enumeration<URL> dirs = ClassLoader.getEnumeration(packageDirName);
        return getClasses(dirs, FLASH_PACKAGE_NAME);
    }
}
