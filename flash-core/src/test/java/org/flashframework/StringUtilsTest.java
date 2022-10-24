/*
 * Copyright 2017-2019 the original author or authors.
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

import org.flashframework.core.util.StringUtils;
import org.junit.Test;

/**
 * {@link StringUtils} Test
 *
 * @author kay
 * @version v2.0
 */
public class StringUtilsTest {

    @Test
    public void isEmpty() {
        boolean isEmpty = StringUtils.isEmpty("");
        System.out.println(isEmpty);

        isEmpty = StringUtils.isEmpty("null");
        System.out.println(isEmpty);

        isEmpty = StringUtils.isEmpty("10");
        System.out.println(isEmpty);
    }

    @Test
    public void toLowerCaseFirstOne() {
        String str = StringUtils.toLowercaseFirst("10");
        System.out.println(str);

        str = StringUtils.toLowercaseFirst("ABCS");
        System.out.println(str);

        str = StringUtils.toLowercaseFirst("aBCS");
        System.out.println(str);
    }
}
