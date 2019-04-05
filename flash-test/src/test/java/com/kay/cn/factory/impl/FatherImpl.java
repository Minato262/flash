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
package com.kay.cn.factory.impl;

import com.kay.cn.factory.Bean;
import com.kay.cn.factory.Father;
import org.flashframework.beans.annotation.Repository;

/**
 * {@link Father} Test.
 *
 * @author kay
 * @version v1.0
 */
@Repository("father")
public class FatherImpl extends Bean implements Father {

    private String mobile;

    public FatherImpl() {
        this.setName("123");
        this.setAge(12);
    }

    @Override
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
