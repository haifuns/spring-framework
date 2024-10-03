package com.test.class0307_order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

/**
 * @author haifuns
 * @date 2024-10-03 15:57
 */
@Slf4j
public class BeanElement {
	public void orderList() {
		int orderValue = 0;
		if (this.getClass().isAnnotationPresent(Order.class)) {
			orderValue = this.getClass().getAnnotation(Order.class).value();
		}
		log.info("List order postProcessorBeanFactory：{}，order: {}", this.getClass().getSimpleName(), orderValue);
	}
}
