package org.flashframework.context.factory;

import org.flashframework.context.annotation.Service;

import javax.annotation.Resource;

/**
 * @author kay
 * @version v1.0
 */
@Service
public class ServiceBean {

    @Resource
    private Father father;

    public Father getFather() {
        System.out.println(father);
        return father;
    }
}
