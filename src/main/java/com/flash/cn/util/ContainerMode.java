package com.flash.cn.util;

/**
 * 容器模式
 *
 * @author kay
 * @version v1.0
 */
public enum ContainerMode {
    SINGLETON("singleton"), MULTIPLE("multiple");

    private static final String FLASH_PROPERTIES_MODE = "containerModes";

    private String mode;

    ContainerMode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return this.mode;
    }

    /**
     * 判断容器模式，配置是否是单例模式
     *
     * @return 是否是单例模式
     */
    public boolean isSingleton() {
        return !ContainerMode.MULTIPLE.getMode().equals(this.mode);
    }

    /**
     * 获取容器配置模式
     *
     * @return 单例或者多例模式
     */
    public static ContainerMode getContainerModes() {
        String mode = new LoadProperties().load(FLASH_PROPERTIES_MODE);
        if (!ContainerMode.MULTIPLE.getMode().equals(mode)) {
            return ContainerMode.SINGLETON;
        }
        else {
            return ContainerMode.MULTIPLE;
        }
    }
}
