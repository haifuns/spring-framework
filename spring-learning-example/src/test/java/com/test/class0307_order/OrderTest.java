package com.test.class0307_order;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author haifuns
 * @date 2024-10-02 17:44
 */
@Slf4j
public class OrderTest {

	@Test
	public void orderTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.test.class0307_order");
		context.refresh();
	}
}
