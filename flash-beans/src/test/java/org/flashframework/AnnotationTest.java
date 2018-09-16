package org.flashframework;

import org.flashframework.beans.container.BeanContainerMode;
import org.flashframework.beans.container.Scope;
import org.junit.Assert;
import org.junit.Test;

/**
 * 注解测试类
 *
 * @author kay
 * @version v1.0
 */
public class AnnotationTest {

    @Test
    public void test() {
        Annotation annotationTest = new Annotation();
        Class<Annotation> clazz = (Class<Annotation>) annotationTest.getClass();

        Scope annotation2 = clazz.getAnnotation(Scope.class);
        Assert.assertNotEquals(annotation2.value(), null);
        Assert.assertEquals(annotation2.value(), BeanContainerMode.SINGLETON);
    }

    @Test
    public void test1() {
        Annotation annotationTest = new Annotation();
        Class<Annotation> clazz = (Class<Annotation>) annotationTest.getClass();
        for (java.lang.annotation.Annotation annotation : clazz.getAnnotations()) {
            System.out.println(annotation);
        }
    }
}

@Scope
class Annotation {

    Annotation() {
    }
}
