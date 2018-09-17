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

import org.flashframework.http.annotation.ResponseBody;

import java.lang.annotation.*;

/**
 * {@code RestController} 注解，相当于 {@code ResponseBody} ＋ {@code Controller}
 * 合在一起的作用
 *
 * @author kay
 * @version v2.0
 * @see Controller
 * @see ResponseBody
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RestController {
}
