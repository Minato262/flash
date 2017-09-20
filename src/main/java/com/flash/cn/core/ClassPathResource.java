package com.flash.cn.core;

import com.flash.cn.annotation.Repository;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
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

    private Enumeration<URL> getEnumeration(String name) {
        try {
            return Thread.currentThread().getContextClassLoader().getResources(name);
        }
        catch (IOException e) {
            throw new ClassPathResourceException();
        }
    }

    private Class<?> loadClass(String className) {
        try {
            return Thread.currentThread().getContextClassLoader().loadClass(className);
        }
        catch (ClassNotFoundException e) {
            throw new ClassPathResourceException();
        }
    }

    private String decode(String s) {
        try {
            return URLDecoder.decode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            throw new ClassPathResourceException();
        }
    }

    private List<Class<?>> getClass(Enumeration<URL> dirs, String packageName) {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        while (dirs.hasMoreElements()) {
            URL url = dirs.nextElement();
            String protocol = url.getProtocol();
            if ("file".equals(protocol)) {
                String filePath = decode(url.getFile());
                checkAddClasses(packageName, filePath, classes);
            }
        }
        return classes;
    }

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
                classes.add(loadClass(packageName + "." + className));
            }
        }
    }

    public List<Class<?>> getClassName(String packageName) {
        String packageDirName = packageName.replace('.', '/');
        Enumeration<URL> dirs = getEnumeration(packageDirName);
        List<Class<?>> result = new ArrayList<Class<?>>();
        for (Class<?> clazz : getClass(dirs, packageName)) {
            System.out.println(clazz.getName());
            Repository annotation = clazz.getAnnotation(Repository.class);
            if (annotation == null) {
                continue;
            }

            System.out.println(annotation);
            System.out.println(annotation.value());
            result.add(clazz);
        }
        return result;
    }
}
