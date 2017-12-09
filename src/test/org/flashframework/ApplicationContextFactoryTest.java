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
package org.flashframework;

import org.flashframework.beans.annotation.Autowired;
import org.flashframework.beans.annotation.Repository;
import org.flashframework.core.factory.Father;
import org.flashframework.core.factory.People;
import org.flashframework.core.factory.User;
import org.junit.Test;

/**
 * @author kay
 * @version v1.0
 */
@Repository("applicationContextFactoryTest")
public class ApplicationContextFactoryTest extends BeforeTest {

    @Autowired
    private Father father;

    @Autowired
    private People people;

    @Autowired
    private User user;

    @Test
    public void test() {
        ApplicationContextFactoryTest test = (ApplicationContextFactoryTest) factory
                .getBean("applicationContextFactoryTest");
        System.out.println(test.father.getAge());
        System.out.println(test.people.getAge());
        System.out.println(test.user.getAge());
    }
}
