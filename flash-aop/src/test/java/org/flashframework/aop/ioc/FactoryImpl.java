package org.flashframework.aop.ioc;

import org.flashframework.beans.annotation.Repository;

/**
 * @author kay
 * @version v1.0
 */
@Repository("factory")
public class FactoryImpl implements Factory {

    public void test() {
        System.out.println("1");
    }
}
