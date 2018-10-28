package org.flashframework.beans.handle;

import org.flashframework.core.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kay
 * @version v1.0
 */
public class HandleChain {

    private List<Handle> list = new ArrayList<>();

    private static final HandleChain chain = new HandleChain();

    public static HandleChain getInstance() {
        return chain;
    }

    public void setHandle(Handle handle) {
        Assert.isNotNull(handle);
        list.add(handle);
    }

    public void load(Class clazz) {
        Assert.isNotNull(clazz);
        for (Handle handle : list) {
            handle.load(clazz);
        }
    }
}
