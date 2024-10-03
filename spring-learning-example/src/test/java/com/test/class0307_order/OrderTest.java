package com.test.class0307_order;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author haifuns
 * @date 2024-10-02 17:44
 */
@Slf4j
public class OrderTest {

	/**
	 * {@link org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor#postProcessProperties}
	 * {@link org.springframework.beans.factory.support.DefaultListableBeanFactory#resolveDependency}
	 * {@link org.springframework.core.OrderComparator#doCompare}
	 * {@link org.springframework.core.annotation.AnnotationAwareOrderComparator}
	 */
	@Test
	public void orderTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.test.class0307_order");
		context.refresh();

		// @Order与bean实例化无关，与@PostConstruct初始化顺序等都无关

		List<BeanElement> beanFactoryPostProcessor = context.getBean(BeanInject.class).getBeanFactoryPostProcessor();
		for (BeanElement beanElement : beanFactoryPostProcessor) {
			beanElement.orderList();
		}
		// 只有这时@Order有用，因为注入时List会排序，排序优先级，PriorityOrdered > Ordered > @Order
	}
}
