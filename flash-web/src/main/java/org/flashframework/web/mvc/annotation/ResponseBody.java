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
package org.flashframework.web.mvc.annotation;

import org.flashframework.beans.annotation.Controller;

import java.lang.annotation.*;

/**
 * {@link ResponseBody} 注解的作用是将 {@link Controller} 的方法返回的对象通过适
 * 当的转换器转换为指定的格式之后，写入到 response 对象的 body 区，通常用来返回 JSON
 * 数据或者是 XML.
 *
 * @author kay
 * @version v2.0
 * @see Controller
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResponseBody {
}
