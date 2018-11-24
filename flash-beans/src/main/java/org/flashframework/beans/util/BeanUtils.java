/*
 * Copyright 2017-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.flashframework.beans.util;

import org.flashframework.beans.BeanCreateFailureException;
import org.flashframework.core.util.Assert;

/**
 * Bean 相关工具类
 *
 * @author kay
 * @version v1.0
 */
public class BeanUtils {

    /**
     * 根据对象的路径，反射生成新的对象
     *
     * @param name 反射对象的对象路径（一定不能为空）
     * @param <T>  弱类型转成指定强类型
     * @return 生成的新的对象
     * @throws IllegalArgumentException   如果字符串为空
     * @throws BeanCreateFailureException 如果对象新建失败
     */
    @SuppressWarnings("unchecked")
    public static <T> T newInstance(String name) throws BeanCreateFailureException {
        Assert.isNotEmpty(name);
        try {
            Class<T> clazz = (Class<T>) Class.forName(name);
            return clazz.newInstance();
        }
        catch (IllegalAccessException e) {
            throw new BeanCreateFailureException("Cannot create " + name + "; is it an interface or an abstract class?");
        }
        catch (InstantiationException e) {
            throw new BeanCreateFailureException("Cannot create " + name + "; has class definition changed? Is there a public constructor?");
        }
        catch (ClassNotFoundException e) {
            throw new BeanCreateFailureException(e);
        }
    }

    /**
     * 根据反射对象，生成新的对象
     *
     * @param clazz 反射对象（一定不能为null）
     * @return 生成的新的对象
     * @throws IllegalArgumentException   如果对象为null
     * @throws BeanCreateFailureException 如果对象新建失败
     */
    @SuppressWarnings("unchecked")
    public static <T> T newInstance(Class clazz) throws BeanCreateFailureException {
        Assert.isNotNull(clazz);
        try {
            return (T) clazz.newInstance();
        }
        catch (IllegalAccessException e) {
            throw new BeanCreateFailureException("Cannot create " + clazz + "; is it an interface or an abstract class?");
        }
        catch (InstantiationException e) {
            throw new BeanCreateFailureException("Cannot create " + clazz + "; has class definition changed? Is there a public constructor?");
        }
    }
}
