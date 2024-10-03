package com.test.class0309_lookup;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author haifuns
 * @date 2024-10-03 17:06
 */
@Slf4j
public class LookupTest {

	/**
	 * https://docs.spring.io/spring-framework/reference/core/beans/lookup-method-invocation.html
	 */
	@Test
	public void lookupTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.test.class0309_lookup");
		context.refresh();

		// BeanB是原型bean，期望每次调用都是一个独立的对象

		BeanA beanA = context.getBean(BeanA.class);
		beanA.printInfo();
		// 普通@Autowired显然不行

		BeanC beanC = context.getBean(BeanC.class);
		beanC.printInfo();
		// @Lookup固定用法，每次拿一个新的BeanB
	}
}
