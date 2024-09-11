package com.test.class0310_dependson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author haifuns
 * @date 2024/9/10 20:44
 */
@Component("beana")
@Slf4j
@DependsOn("beanb")
public class DependsOnA {

    @PostConstruct
    public void initMethod() {
        log.debug("a init");
    }
}
