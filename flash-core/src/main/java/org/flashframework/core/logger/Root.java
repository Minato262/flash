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
package org.flashframework.core.logger;

/**
 * 日志配置是否启动
 *
 * @author kay
 * @version v2.0
 */
public enum Root {
    TRUE("true", true),
    FALSE("false", false);

    private String root;
    private boolean isRoot;

    Root(String root, boolean isRoot) {
        this.root = root;
        this.isRoot = isRoot;
    }

    public String getRoot() {
        return root;
    }

    public boolean getIsRoot() {
        return isRoot;
    }

    public static boolean getIsRoot(String strRoot) {
        for (Root root : Root.values()) {
            if (root.getRoot().equals(strRoot)) {
                return root.getIsRoot();
            }
        }
        return true;
    }
}
