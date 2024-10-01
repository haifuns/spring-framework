package com.test.class0305_resource;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author haifuns
 * @date 2024-10-01 16:10
 */
@Slf4j
public class ResourceTest {

	/**
	 * {@link org.springframework.context.annotation.CommonAnnotationBeanPostProcessor#postProcessProperties}
	 * {@link org.springframework.beans.factory.support.DefaultListableBeanFactory#resolveDependency}
	 */
	@Test
	public void resourceTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.test.class0305_resource");
		context.refresh();

		ResourceI resourceI = context.getBean(ResourceA.class).getResourceI();
		log.debug("resourceI：{}", resourceI);

		// @Resource 如果注解指定了name或者没有指定name但是属性名已经被spring实例化/解析，则直接通过指定的name/属性名找，
		// 			否则通过类型找
		// @Resource 源码入口：
		// CommonAnnotationBeanPostProcessor.ResourceElement#inject
	}
}
