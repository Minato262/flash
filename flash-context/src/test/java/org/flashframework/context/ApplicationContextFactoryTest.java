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
package org.flashframework.context;

import org.flashframework.beans.annotation.Autowired;
import org.flashframework.context.annotation.Service;
import org.flashframework.context.factory.ApplicationContextFactory;
import org.flashframework.context.factory.Father;
import org.flashframework.context.factory.People;
import org.flashframework.context.factory.User;
import org.junit.Assert;
import org.junit.Test;

/**
 * {@link ApplicationContextFactory} Test
 *
 * @author kay
 * @version v1.0
 */
@Service("test")
public class ApplicationContextFactoryTest extends BeforeTest {

    @Autowired
    private Father father;

    @Autowired
    private People people;

    //@Autowired
    private User user;

    @Test
    public void test() {
        ApplicationContextFactoryTest test = (ApplicationContextFactoryTest) factory.getBean("test");
        Assert.assertNotNull(test.father);
        Assert.assertNotNull(test.people);
        //Assert.assertNotNull(test.user);
    }
}
