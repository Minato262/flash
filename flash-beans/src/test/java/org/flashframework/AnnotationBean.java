package org.flashframework;

import org.flashframework.beans.annotation.Autowired;
import org.flashframework.beans.container.Scope;

import javax.annotation.Resource;

/**
 * @author kay
 * @version v1.0
 */
@Scope
public class AnnotationBean {

    @Autowired
    private Integer i;

    @Resource
    private Integer j;

    AnnotationBean() {
    }
}
