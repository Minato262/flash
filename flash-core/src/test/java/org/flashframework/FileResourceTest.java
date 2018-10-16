package org.flashframework;

import org.flashframework.core.io.FileResource;
import org.junit.Test;

/**
 * @author kay
 * @version v1.0
 */
public class FileResourceTest {

    @Test
    public void test() {
        FileResource resource = new FileResource("1123123", "12312312");
        System.out.println(resource.getFileClassName());
        System.out.println(resource.getFileName());
    }
}
