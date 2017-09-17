package com.flash.cn.core;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kay
 * @version v1.0
 */
public class ClassPathResource {

    private static Map<String, String> container = new HashMap<String, String>();

    public List<String> getClassName(String packageName) {
        String c = ClassLoader.getSystemResource("").getPath();
        String filePath = c + packageName.replace(".", "\\");
        return getClassName(filePath, null);
    }

    private List<String> getClassName(String filePath, List<String> className) {
        List<String> myClassName = new ArrayList<String>();
        File file = new File(filePath);
        File[] childFiles = file.listFiles();
        assert childFiles != null;
        for (File childFile : childFiles) {
            if (childFile.isDirectory()) {
                myClassName.addAll(getClassName(childFile.getPath(), myClassName));
            }
            else {
                String childFilePath = childFile.getPath();
                childFilePath = childFilePath.substring(childFilePath.indexOf("\\classes") + 9, childFilePath.lastIndexOf("."));
                childFilePath = childFilePath.replace("\\", ".");
                myClassName.add(childFilePath);
            }
        }
        return myClassName;
    }
}
