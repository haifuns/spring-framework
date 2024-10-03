package com.test.class0311_registerbean;

import lombok.extern.slf4j.Slf4j;

/**
 * @author haifuns
 * @date 2024-10-03 17:30
 */
@Slf4j
public class BeanA {
	public BeanA() {
		log.info("BeanA默认构造方法");
	}

	public BeanA(String source) {
		log.info("BeanA有参构造方法，来源：{}", source);
	}
}
