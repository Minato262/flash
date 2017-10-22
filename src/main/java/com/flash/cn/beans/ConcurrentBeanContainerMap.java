package com.flash.cn.beans;

import com.flash.cn.util.Assert;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kay
 * @version v1.0
 */
public class ConcurrentBeanContainerMap extends ConcurrentHashMap<String, Object> implements BeanContainerMap {

    /**
     * 根据 key 获取容器中的对象
     *
     * @param key 容器关键字(一定不能为空)
     * @param <T> 弱类型转换成强类型
     * @return 返回容器中的对象
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        Assert.isNotEmpty(key);
        return (T) super.get(key);
    }

    /**
     * 根据 key 获取容器中的对象
     *
     * @param key    容器关键字(一定不能为空)
     * @param object 存储对象
     */
    @Override
    public Object put(String key, Object object) {
        Assert.isNotEmpty(key);
        return super.put(key, object);
    }
}
