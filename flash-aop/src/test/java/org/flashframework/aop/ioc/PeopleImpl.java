package org.flashframework.aop.ioc;

import org.flashframework.context.annotation.Service;

/**
 * @author kay
 * @version v1.0
 */
@Service
public class PeopleImpl implements People {

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
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
