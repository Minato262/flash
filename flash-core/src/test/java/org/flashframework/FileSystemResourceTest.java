package org.flashframework;

import org.flashframework.core.io.FileSystemResource;
import org.junit.Test;

/**
 * @author kay
 * @version v1.0
 */
public class FileSystemResourceTest {

    @Test
    public void test() {
        FileSystemResource resource = new FileSystemResource("1123123", "12312312");
        System.out.println(resource.getFileClassName());
        System.out.println(resource.getFileName());
    }
}
