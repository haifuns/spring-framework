package com.test.class0311_registerbean;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author haifuns
 * @date 2024-10-03 17:29
 */
@Slf4j
public class RegisterBeanTest {
	@Test
	public void test1() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(BeanA.class);
		context.registerBeanDefinition("beanA", beanDefinition);
		context.refresh();
		// 通过BeanDefinition注册BeanA到spring，实例化方式为默认构造方法
	}

	@Test
	public void test2() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(BeanA.class);
		beanDefinition.setFactoryBeanName("objectFactory");
		beanDefinition.setFactoryMethodName("instanceObject");

		context.register(ObjectFactory.class);
		context.registerBeanDefinition("beanA", beanDefinition);
		context.refresh();
		// 通过实例工厂方法实例化BeanA实例
		// 另外可以通过静态工厂方法实例化Bean，不需要实例化工厂，但是只能通过xml方法配置
	}

	@Test
	public void test3() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(BeanA.class);
		beanDefinition.setFactoryBeanName("objectFactory");
		beanDefinition.setFactoryMethodName("instanceObject");
		context.register(ObjectFactory.class);

		beanDefinition.setInstanceSupplier(SupplierFactory::getObject);

		context.registerBeanDefinition("beanA", beanDefinition);
		context.refresh();
		// 通过Supplier实例化BeanA实例
		// Supplier效率高（高于反射），实例化优先级高，如果同时指定了工厂、Supplier，使用Supplier
	}
}
