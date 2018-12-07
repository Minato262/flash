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
package org.flashframework.aop.demo;

/**
 * @author kay
 * @version v2.0
 */
public class FacadeImpl implements Facade {

    @Override
    public void doSomething() {
        System.out.println("在业务组件 BusinessClass 中调用方法: doSomething()");
    }

    @Override
    public void doSomething1() {
        System.out.println("在业务组件 BusinessClass1 中调用方法: doSomething1()");
    }
}
