package com.test.class0307_order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author haifuns
 * @date 2024-10-02 17:49
 */
@Component
@Slf4j
@Order(3)
public class OrderB {
	public OrderB() {
		log.info("OrderB 构造方法，order: {}", this.getClass().getAnnotation(Order.class).value());
	}

	@PostConstruct
	public void init() {
		log.info("OrderB init 方法");
	}
}
