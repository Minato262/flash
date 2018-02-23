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
package org.flashframework.web.http;

/**
 * HTTP请求方式，HTTP请求可以使用多种请求方法:
 * <p>HTTP1.0定义了三种请求方法： GET, POST 和 HEAD方法。</p>
 * <p>HTTP1.1新增了五种请求方法：OPTIONS, PUT, DELETE, TRACE 和 CONNECT 方法。</p>
 * 其中:
 * <p>GET，POST，PUT 以及 DELETE 是最为常用的</p>
 *
 * @author kay
 * @version v2.0
 */
public enum RequestMethod {

    /**
     * 请求指定的页面信息，并返回实体主体。
     */
    GET,

    /**
     * 向指定资源提交数据进行处理请求（例如提交表单或者上传文件）。数据被包含在请求体中,
     * POST请求可能会导致新的资源的建立和/或已有资源的修改。
     */
    POST,

    /**
     * 从客户端向服务器传送的数据取代指定的文档的内容。
     */
    PUT,

    /**
     * 请求服务器删除指定的页面。
     */
    DELETE
}
