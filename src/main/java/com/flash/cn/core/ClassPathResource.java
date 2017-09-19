package com.flash.cn.core;

import com.flash.cn.annotation.Autowired;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
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

    public void getClassName(String packageName) {
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
                    findAndAddClassesInPackageByFile(packageName, filePath, true, classes);
                }
                catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }

        for (Class<?> clazz : classes) {
            Class<?> c = clazz;
            System.out.println(c.getName());
            Method[] methods = c.getMethods();
            for (Method method : methods) {
                Autowired annotation1 = method.getAnnotation(Autowired.class);
                if (annotation1 != null) {
                    System.out.println(annotation1);
                }
            }
        }
    }

    /**
     * findAndAddClassesInPackageByFile方法描述:
     * 作者:thh
     * 日期:2016年7月18日 下午5:41:12
     * 异常对象:@param packageName
     * 异常对象:@param packagePath
     * 异常对象:@param recursive
     * 异常对象:@param classes
     */
    public static void findAndAddClassesInPackageByFile(String packageName, String packagePath, final boolean recursive, List<Class<?>> classes) {
        File dir = new File(packagePath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }

        File[] dirfiles = dir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
            }
        });

        assert dirfiles != null;
        for (File file : dirfiles) {
            if (file.isDirectory()) {
                findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, classes);
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
