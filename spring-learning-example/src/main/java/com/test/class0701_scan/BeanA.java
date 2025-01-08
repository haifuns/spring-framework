package com.test.class0701_scan;

import com.test.class0501_context.BeanB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author haifuns
 * @date 2024-10-16 19:35
 */
@Slf4j
@Component
public class BeanA {

    public BeanA() {
        log.info("BeanA constructor");
    }

    @PostConstruct
    public void init() {
        log.info("BeanA init");
    }
}
