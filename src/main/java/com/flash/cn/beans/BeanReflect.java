package com.flash.cn.beans;

/**
 * 反射工具类
 *
 * @author kay
 * @version v1.0
 */
public class BeanReflect {

    /**
     * 反射生成新的对象
     *
     * @param name 反射对象的对象路径
     * @param <T>  弱类型转成指定强类型
     * @return 生成的新的对象
     * @throw BeanCreateFailureException 对象生成失败异常
     */
    @SuppressWarnings("unchecked")
    public static <T> T newInstance(String name) {
        try {
            Class<T> clazz = (Class<T>) Class.forName(name);
            return clazz.newInstance();
        }
        catch (Exception e) {
            throw new BeanCreateFailureException(e);
        }
    }
}
