package com.test.class0501_context;

import com.test.class0501_context.beandefinitionregistry.ManualBeanDefinitionRegistry;
import com.test.class0501_context.beandefinitionregistry.ParentBeanDefinitionRegistry;
import com.test.class0501_context.beanfactorypostprocessor.ManualBeanFactoryPostProcessor;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author haifuns
 * @date 2024-10-16 17:16
 */
public class ContextTest {
	@Test
	public void testBeanDefinitionRegistryOrder() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.addBeanFactoryPostProcessor(new ManualBeanDefinitionRegistry());
		context.addBeanFactoryPostProcessor(new ManualBeanFactoryPostProcessor());
		context.register(ContextConfig.class);
		context.refresh();

		// 执行顺序：
		// ManualBeanDefinitionRegistry api提供的优先
		// -> PriorityOrderBeanDefinitionRegistry 扫描bean，实现PriorityOrdered
		// -> NormalBeanDefinitionRegistry 扫描bean
		// -> ParentBeanDefinitionRegistry 扫描bean，注册ChildBeanDefinitionRegistry
		// -> ZBeanDefinitionRegistry 扫描bean
		// -> ChildBeanDefinitionRegistry
	}

	@Test
	public void testBeanDefinitionRegistryOrder2() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.addBeanFactoryPostProcessor(new ParentBeanDefinitionRegistry());
		context.addBeanFactoryPostProcessor(new ManualBeanDefinitionRegistry());
		context.register(ContextConfig.class);
		context.refresh();

		// 执行顺序：
		//	ParentBeanDefinitionRegistry
		//	ManualBeanDefinitionRegistry
		//	PriorityOrderedBeanDefinitionRegistry
		//	ChildBeanDefinitionRegistry
		//	NormalBeanDefinitionRegistry
		//	ParentBeanDefinitionRegistry
		//	ZBeanDefinitionRegistry
	}
}
