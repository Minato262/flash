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
package org.flashframework.core.io;

import org.flashframework.core.util.Decoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import static org.flashframework.core.io.FileResource.*;

/**
 * 根据包路径，获取 Class 资源列表
 *
 * @author kay
 * @version v1.0
 */
public class ClassResourceLoader extends AbstractClassResource implements Resource {

    private static final Logger log = LoggerFactory.getLogger(ClassResourceLoader.class);

    /**
     * 扫描并获取到 Class 资源列表，暂不支持扫描 jar 包
     *
     * @param urlElements url 元素
     * @param packageName 相对路径包名（不能为空）
     * @return Class 资源列表
     */
    @Override
    protected List<Class<?>> loadClasses(Enumeration<URL> urlElements, String packageName) {
        log.info("{}, load class start", packageName);
        List<Class<?>> classes = new ArrayList<>();
        while (urlElements.hasMoreElements()) {
            URL url = urlElements.nextElement();
            String protocol = url.getProtocol();

            // 暂时不支持扫描 jar 包
            if (FILE_NAME.equals(protocol)) {
                String packagePath = Decoder.decode(url.getFile());
                findClassLocal(packageName, packagePath, classes);
            }
        }
        log.info("{}, load class end", packageName);
        return classes;
    }

    /**
     * 递归，扫描全部 Class 的本地资源，并且加入资源列表
     *
     * @param packageName 相对路径包名称
     * @param packagePath 相对包路径
     * @param classes     Class 资源列表
     */
    private void findClassLocal(String packageName, String packagePath, List<Class<?>> classes) {
        FileResource fileResource = new FileResource(packagePath, packageName);
        List<FileResource> files = fileResource.getFileList();
        if (files == null) {
            return;
        }

        for (FileResource file : files) {
            if (file.isDirectory()) {
                findClassLocal(file.getFileName(), file.getAbsolutePath(), classes);
                continue;
            }

            if(log.isDebugEnabled()) {
                log.debug("load Class，class path: {}", file.getFileClassName());
            }
            Class<?> clazz = loadClass(file.getFileClassName());
            classes.add(clazz);
        }
    }

    /**
     * 根据类的名称，载入类的资源
     *
     * @param name 类的名称
     * @return 载入的 Class
     * @throws ClassResourceLoadFailureException 如果根据资源名称载入没有找到对应的类，则抛出异常
     */
    private Class<?> loadClass(String name) {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(name);
        }
        catch (ClassNotFoundException e) {
            throw new ClassResourceLoadFailureException();
        }
    }
}
