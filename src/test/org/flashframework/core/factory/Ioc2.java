/*
 * Copyright 2017-2017 the original author or authors.
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
package org.flashframework.core.factory;

import org.flashframework.annotation.Autowired;
import org.flashframework.annotation.Controller;
import org.flashframework.context.ApplicationContext;
import org.flashframework.context.ApplicationContextFactory;
import org.junit.Test;

/**
 * @author kay
 * @version v1.0
 */
@Controller
public class Ioc2 {

    @Autowired
    private Father father;

    @Autowired
    private People people;

    @Autowired
    private User user;

    @Autowired
    private Ioc1 ioc1;

    public Father getFather() {
        return father;
    }

    public People getPeople() {
        return people;
    }

    public User getUser() {
        return user;
    }

    public Ioc1 getIoc1() {
        return ioc1;
    }

    @Test
    public void test(){
        ApplicationContext factory = new ApplicationContextFactory();
        Ioc2 ioc2 = (Ioc2) factory.getBean("ioc2");
        System.out.println(ioc2);
        System.out.println(ioc2.getFather());
        System.out.println(ioc2.getPeople());
        System.out.println(ioc2.getUser());
        System.out.println(ioc2.getIoc1());
        System.out.println(ioc2.getIoc1().getFather());
        System.out.println(ioc2.getIoc1().getPeople());
        System.out.println(ioc2.getIoc1().getUser());
        System.out.println(ioc2.getIoc1().getIoc());
        System.out.println(ioc2.getIoc1().getIoc().getUser());
        System.out.println(ioc2.getIoc1().getIoc().getPeople());
        System.out.println(ioc2.getIoc1().getIoc().getFather());
    }
}
