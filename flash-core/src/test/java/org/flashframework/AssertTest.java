package org.flashframework;

import org.flashframework.util.Assert;
import org.junit.Test;

/**
 * {@link Assert} Test
 *
 * @author kay
 * @version v1.0
 */
public class AssertTest {

    @Test
    public void isNotNull() {
        Assert.isNotNull(null);
        Assert.isNotNull("");
        Assert.isNotNull("null");
        Assert.isNotNull("ABCS");
    }

    @Test
    public void isNotEmpty() {
        Assert.isNotEmpty(null);
        Assert.isNotEmpty("");
        Assert.isNotEmpty("null");
        Assert.isNotEmpty("ABCS");
    }
}
