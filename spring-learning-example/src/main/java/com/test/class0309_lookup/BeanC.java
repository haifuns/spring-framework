package com.test.class0309_lookup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * @author haifuns
 * @date 2024-10-03 17:00
 */
@Component
@Slf4j
public abstract class BeanC {

	public void printInfo() {
		BeanB beanB = createBeanB();
		log.info("beanB: {}", beanB);
		beanB = createBeanB();
		log.info("beanB: {}", beanB);
	}

	@Lookup
	public abstract BeanB createBeanB();
}
