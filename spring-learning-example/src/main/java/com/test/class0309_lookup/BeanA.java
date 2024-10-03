package com.test.class0309_lookup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author haifuns
 * @date 2024-10-03 17:00
 */
@Slf4j
@Component
public class BeanA {

	@Autowired
	BeanB beanB;

	public void printInfo() {
		log.info("beanB: {}", beanB);
		log.info("beanB: {}", beanB);
	}
}
