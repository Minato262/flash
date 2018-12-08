package org.flashframework.aop.ioc;

import org.flashframework.beans.annotation.Autowired;
import org.flashframework.context.annotation.Service;

import javax.annotation.Resource;

/**
 * @author kay
 * @version v1.0
 */
@Service("people1")
public class PeopleImpl implements People {

    @Resource
    private Factory factory;

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        System.out.println(age);
        factory.test();
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
