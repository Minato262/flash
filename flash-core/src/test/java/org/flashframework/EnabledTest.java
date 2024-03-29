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

import org.flashframework.core.logger.Enabled;
import org.junit.Test;

/**
 * {@link Enabled} Test
 *
 * @author kay
 * @version v1.0
 */
public class EnabledTest {

    @Test
    public void test() {
        Enabled enabled = Enabled.TRUE;
        System.out.println(enabled);

        enabled = Enabled.FALSE;
        System.out.println(enabled);
    }
}
