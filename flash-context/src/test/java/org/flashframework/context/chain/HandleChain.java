package org.flashframework.context.chain;

import org.flashframework.core.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kay
 * @version v1.0
 */
public class HandleChain {

    private List<Handle> list = new ArrayList<>();

    public void setHandle(Handle handle) {
        Assert.isNotNull(handle);
        list.add(handle);
    }
}
