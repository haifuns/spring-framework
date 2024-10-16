package com.test.class0501_context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;

/**
 * @author haifuns
 * @date 2024-10-16 19:35
 */
@Slf4j
public class BeanA {

	public BeanA() {
		log.info("BeanA constructor");
	}

	@Bean
	public BeanB beanB() {
		log.info("BeanA @bean create BeanB");
		return new BeanB();
	}
}
