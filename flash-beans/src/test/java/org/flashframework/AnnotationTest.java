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
