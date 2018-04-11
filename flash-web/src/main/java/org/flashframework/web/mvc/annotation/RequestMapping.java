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

import org.flashframework.http.RequestMethod;

import java.lang.annotation.*;

/**
 * {@code RequestMapping} 会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。
 * <p>同时也可以在控制器类的级别和/或其中的方法的级别上使用</p>
 *
 * @author kay
 * @version v2.0
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface RequestMapping {

    /**
     * 标识控制来进行请求url向物理视图的映射
     *
     * @return 标识控制来进行请求url 默认为空
     */
    String value() default "";

    /**
     * url 映射的请求方式
     *
     * @return 请求方式 默认为 GET 请求
     */
    RequestMethod[] method() default {RequestMethod.GET};

    /**
     * HTTP 请求 消息头
     *
     * @return 请求头
     */
    String[] headers() default {};

    /**
     * 指定request中必须包含某些参数值是，才让该方法处理。
     *
     * @return 指定request中必须包含某些参数值
     */
    String[] params() default {};

    /**
     * 指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回
     *
     * @return 指定返回值类型
     */
    String[] produces() default {};

    /**
     * 指定处理请求的提交内容类型（Content-Type）
     * <p>eg: application/json, text/html;</p>
     *
     * @return 指定处理请求的提交内容类型
     */
    String[] consumes() default {};
}
