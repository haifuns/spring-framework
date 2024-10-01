package com.test.class0305_resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author haifuns
 * @date 2024/9/11 22:28
 */
@Component
public class ResourceA {

    @Resource
    private ResourceI resourceIb;

    public ResourceI getResourceI() {
        return resourceIb;
    }
}
