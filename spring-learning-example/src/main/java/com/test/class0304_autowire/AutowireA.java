package com.test.class0304_autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author haifuns
 * @date 2024/9/11 22:28
 */
@Component
public class AutowireA {

    @Autowired
    private AutowireI autowireIa;

    public AutowireI getAutowireI() {
        return autowireIa;
    }
}
