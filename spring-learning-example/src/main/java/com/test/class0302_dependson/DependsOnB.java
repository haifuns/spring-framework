package com.test.class0302_dependson;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author haifuns
 * @date 2024/9/10 20:44
 */
@Component("beanb")
@Slf4j
public class DependsOnB {

    static {
        log.debug("b static");
    }

    @PostConstruct
    public void initMethod() {
        log.debug("b init");
    }
}
