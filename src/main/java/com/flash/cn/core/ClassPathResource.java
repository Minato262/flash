package com.flash.cn.core;

import com.flash.cn.util.EncodingUtils;

import java.io.File;
import java.io.FileFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Class Path Resource.
 *
 * @author kay
 * @version v1.0
 */
public class ClassPathResource {

    /**
     * 获取到 Class 类集合
     *
     * @param urlElements url 入参
     * @param packageName 包名
     * @return Class 类集合
     */
    private List<Class<?>> getClassesByUrl(Enumeration<URL> urlElements, String packageName) {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        while (urlElements.hasMoreElements()) {
            URL url = urlElements.nextElement();
            String protocol = url.getProtocol();
            if ("file".equals(protocol)) {
                String filePath = EncodingUtils.decode(url.getFile());
                checkAddClasses(packageName, filePath, classes);
            }
        }
        return classes;
    }

    /**
     * 检测全部 Class 类集合
     *
     * @param packageName 包名称
     * @param packagePath 包路径
     * @param classes     Class 类集合
     */
    private void checkAddClasses(String packageName, String packagePath, List<Class<?>> classes) {
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
                checkAddClasses(packageName + "." + file.getName(), file.getAbsolutePath(), classes);
            }
            else {
                String className = file.getName().substring(0, file.getName().length() - 6);
                classes.add(ClassUtils.loadClass(packageName + "." + className));
            }
        }
    }

    /**
     * 获取 Class 名称
     *
     * @param packageName 包名称
     * @return Class 类集合
     */
    public List<Class<?>> getClasses(String packageName) {
        String packageDirName = packageName.replace('.', '/');
        Enumeration<URL> dirs = ClassUtils.getEnumeration(packageDirName);

        List<Class<?>> result = new ArrayList<Class<?>>();
        result.addAll(getClassesByUrl(dirs, packageName));
        return result;
    }
}
