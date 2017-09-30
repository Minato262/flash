package com.flash.cn.util;

/**
 * @author kay
 * @version v1.0
 */
public enum ContainerMode {
    SINGLETON("singleton"), MULTIPLE("multiple");

    private String mode;

    ContainerMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return this.mode;
    }

    public boolean isSingleton() {
        return "singleton".equals(this.mode);
    }
}
