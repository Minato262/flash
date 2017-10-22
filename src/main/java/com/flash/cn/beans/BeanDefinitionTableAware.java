package com.flash.cn.beans;

/**
 * @author kay
 * @version v1.0
 */
public final class BeanDefinitionTableAware implements BeanDefinitionAware {

    /** Bean Definition 注册表 */
    private BeanDefinitionMap registryTable = new ConcurrentBeanDefinitionMap();

    private static BeanDefinitionAware aware = new BeanDefinitionTableAware();

    private BeanDefinitionTableAware(){
        //
    }

    public static BeanDefinitionAware getInstance(){
        synchronized (BeanDefinitionTableAware.class){
            return aware;
        }
    }

    @Override
    public BeanDefinitionMap getTable() {
        return registryTable;
    }
}
