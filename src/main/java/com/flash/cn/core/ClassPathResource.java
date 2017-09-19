package com.flash.cn.core;

import com.flash.cn.annotation.Autowired;

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
 * @author kay
 * @version v1.0
 */
public class ClassPathResource {

    public List<Class<?>> getClassName(String packageName) {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        String packageDirName = packageName.replace('.', '/');
        Enumeration<URL> dirs = null;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        assert dirs != null;
        while (dirs.hasMoreElements()) {
            URL url = dirs.nextElement();
            String protocol = url.getProtocol();
            if ("file".equals(protocol)) {
                try {
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    findAndAddClasses(packageName, filePath, classes);
                }
                catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }

        List<Class<?>> result = new ArrayList<Class<?>>();
        for (Class<?> clazz : classes) {
            System.out.println(clazz.getName());
            Autowired annotation = clazz.getAnnotation(Autowired.class);
            if (annotation == null) {
                continue;
            }

            System.out.println(annotation);
            System.out.println(annotation.value());
            result.add(clazz);
        }
        return result;
    }

    public void findAndAddClasses(String packageName, String packagePath, List<Class<?>> classes) {
        File dir = new File(packagePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }

        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return (file.isDirectory()) || (file.getName().endsWith(".class"));
            }
        });

        assert files != null;
        for (File file : files) {
            if (file.isDirectory()) {
                findAndAddClasses(packageName + "." + file.getName(), file.getAbsolutePath(), classes);
            }
            else {
                String className = file.getName().substring(0, file.getName().length() - 6);
                try {
                    classes.add(Thread.currentThread().getContextClassLoader().loadClass(packageName + "." + className));
                }
                catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
