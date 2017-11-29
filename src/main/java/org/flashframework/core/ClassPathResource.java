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
package org.flashframework.core;

import org.flashframework.util.Decoder;

import java.io.File;
import java.io.FileFilter;
import java.lang.*;
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
public class ClassPathResource extends ClassLoader implements Resource {

    /**
     * 载入 Class 资源
     *
     * @param name 资源名称
     * @return 载入的 Class
     * @throws ClassLoaderFailureException 如果根据资源名称载入没有找到对应的类
     */
    private Class<?> loadClass(String name) {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(name);
        }
        catch (ClassNotFoundException e) {
            throw new ClassLoaderFailureException(e);
        }
    }

    /**
     * 检测全部 Class 资源清单
     *
     * @param packageName 相对路径包名称
     * @param packagePath 相对包路径
     * @param classes     Class 资源清单
     */
    private void checkClasses(String packageName, String packagePath, List<Class<?>> classes) {
        File dir = new File(packagePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }

        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory() || file.getName().endsWith(".class");
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
                classes.add(loadClass(packageName + "." + className));
            }
        }
    }

    /**
     * 获取到 Class 资源列表
     *
     * @param urlElements url 元素
     * @param packageName 相对路径包名
     * @return Class 资源列表
     */
    @Override
    protected List<Class<?>> getClasses(Enumeration<URL> urlElements, String packageName) {
        List<Class<?>> classes = new ArrayList<>();
        while (urlElements.hasMoreElements()) {
            URL url = urlElements.nextElement();
            String protocol = url.getProtocol();

            // 暂时不支持扫描 jar
            if ("file".equals(protocol)) {
                String filePath = Decoder.decode(url.getFile());
                checkClasses(packageName, filePath, classes);
            }
        }
        return classes;
    }
}
