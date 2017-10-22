package com.flash.cn.beans;

import java.util.concurrent.ConcurrentMap;

/**
 * @author kay
 * @version v1.0
 */
public interface BeanDefinitionMap extends ConcurrentMap<String, Class> {

    Class put(String key, Class value);
}
