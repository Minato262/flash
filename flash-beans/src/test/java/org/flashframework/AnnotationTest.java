/*
 * Copyright 2017-2019 the original author or authors.
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
package org.flashframework;

import org.flashframework.beans.annotation.Autowired;
import org.flashframework.beans.container.BeanContainerMode;
import org.flashframework.beans.container.Scope;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 注解测试类
 *
 * @author kay
 * @version v1.0
 */
public class AnnotationTest {

    @Test
    public void test() {
        AnnotationBean annotationTest = new AnnotationBean();
        Class<AnnotationBean> clazz = (Class<AnnotationBean>) annotationTest.getClass();

        Scope annotation2 = clazz.getAnnotation(Scope.class);
        Assert.assertNotEquals(annotation2.value(), null);
        Assert.assertEquals(annotation2.value(), BeanContainerMode.SINGLETON);
    }

    @Test
    public void test1() {
        AnnotationBean annotationTest = new AnnotationBean();
        Class<AnnotationBean> clazz = (Class<AnnotationBean>) annotationTest.getClass();
        for (Annotation annotation : clazz.getAnnotations()) {
            System.out.println(annotation);
        }
    }

    @Test
    public void test2() {
        AnnotationBean annotationTest = new AnnotationBean();
        Field[] fields = annotationTest.getClass().getDeclaredFields();
        for (Field f : fields) {
            Annotation[] annotations = f.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
                if (annotation instanceof Autowired) {
                    System.out.println(annotation);
                }
            }
        }
    }
}
