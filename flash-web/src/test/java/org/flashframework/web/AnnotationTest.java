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
package org.flashframework.web;

import org.flashframework.http.RequestMethod;
import org.flashframework.http.annotation.RequestBody;
import org.flashframework.http.annotation.RequestHeader;
import org.flashframework.http.annotation.ResponseBody;
import org.flashframework.web.mvc.annotation.*;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * {@link RequestMapping} 和 {@link RequestParam} 注解的测试类
 *
 * @author kay
 * @version v2.0
 */
public class AnnotationTest {

    @SuppressWarnings("unchecked")
    @Test
    public void annotation() throws InvocationTargetException, IllegalAccessException {
        Annotation annotationTest = new Annotation();
        Class<Annotation> clazz = (Class<Annotation>) annotationTest.getClass();

        RequestMapping annotation = clazz.getAnnotation(RequestMapping.class);
        Assert.assertNotEquals(annotation.value(), null);
        Assert.assertEquals(annotation.value(), "annotation");
        Assert.assertNotEquals(annotation.method(), null);

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(RequestMapping.class)) {
                RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                Assert.assertNotEquals(requestMapping, null);

                Assert.assertNotEquals(requestMapping.value(), null);
                Assert.assertNotEquals(requestMapping.method(), null);
                Assert.assertNotEquals(requestMapping.params(), null);
                Assert.assertNotEquals(requestMapping.headers(), null);
                Assert.assertNotEquals(requestMapping.consumes(), null);
                Assert.assertNotEquals(requestMapping.produces(), null);
            }
            if (method.isAnnotationPresent(ResponseBody.class)) {
                ResponseBody responseBody = method.getAnnotation(ResponseBody.class);
                Assert.assertNotEquals(responseBody, null);
            }

            Parameter[] params = method.getParameters();
            if (params.length != 0) {
                method.invoke(annotationTest, 1L);
            }

            for (Parameter param : params) {
                if (param.isAnnotationPresent(RequestParam.class)) {
                    RequestParam requestParam = param.getAnnotation(RequestParam.class);
                    Assert.assertNotEquals(requestParam, null);
                }
            }
        }

        System.out.println(annotationTest.getGetId());
        System.out.println(annotationTest.getPostId());
        System.out.println(annotationTest.getPutId());
        System.out.println(annotationTest.getDeleteId());
        System.out.println(annotationTest.getHandler());
    }
}

@RestController
@RequestMapping(value = "annotation")
class Annotation {
    private Long getId;
    private Long postId;
    private Long putId;
    private Long deleteId;

    private Long handler;

    public Long getGetId() {
        return getId;
    }

    @RequestMapping(value = "get", method = {RequestMethod.GET})
    @ResponseBody
    public void setGetId(@RequestParam("getId") Long getId) {
        this.getId = getId;
    }

    public Long getPostId() {
        return postId;
    }

    @RequestMapping(value = "post", method = {RequestMethod.POST})
    @ResponseBody
    @RequestBody
    public void setPostId(@RequestParam("postId") Long postId) {
        this.postId = postId;
    }

    public Long getPutId() {
        return putId;
    }

    @RequestMapping(value = "put", method = {RequestMethod.PUT})
    @ResponseBody
    public void setPutId(@RequestParam("putId") Long putId) {
        this.putId = putId;
    }

    public Long getDeleteId() {
        return deleteId;
    }

    @RequestMapping(value = "delete", method = {RequestMethod.DELETE})
    @ResponseBody
    public void setDeleteId(@RequestParam("deleteId") Long deleteId) {
        this.deleteId = deleteId;
    }

    @RequestHeader
    @ResponseBody
    public Long getHandler() {
        return handler;
    }

    @RequestMapping(value = "post", method = {RequestMethod.POST}, headers = "")
    @ResponseBody
    public void setHandler(Long handler) {
        this.handler = handler;
    }
}
