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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kay
 * @version v2.0
 */
public class FileSystemResource {

    private File file;

    private String packageName;

    /** 文件常用字节——斜杠 '/' */
    public static final char FILE_SLASH = '/';

    /** 文件常用字节——点 '.' */
    public static final char FILE_DOT = '.';

    /** 文件常量——名称 "file" */
    public static final String FILE_NAME = "file";

    /** 文件常量——后缀 "class" */
    private static final String FILE_CLASS = FILE_DOT + "class";

    private FileSystemResource(File file, String packageName) {
        this.file = file;
        this.packageName = packageName;
    }

    public FileSystemResource(String pathName, String packageName){
        this.file = new File(pathName);
        this.packageName = packageName;
    }

    public final String getFileName() {
        return packageName + FILE_DOT + file.getName();
    }

    public final String getFileClassName() {
        final String className = file.getName().substring(0, (file.getName().length() - FILE_CLASS.length()));
        return packageName + FILE_DOT + className;
    }

    public boolean isDirectory() {
        return file.isDirectory();
    }

    public String getAbsolutePath() {
        return file.getAbsolutePath();
    }

    public List<FileSystemResource> getFileList() {
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }

        File[] files = file.listFiles(file -> file.isDirectory() || file.getName().endsWith(FILE_CLASS));
        if (files == null) {
            return null;
        }

        List<FileSystemResource> resources = new ArrayList<>();
        for (File file : files) {
            FileSystemResource resource = new FileSystemResource(file, packageName);
            resources.add(resource);
        }
        return resources;
    }
}
