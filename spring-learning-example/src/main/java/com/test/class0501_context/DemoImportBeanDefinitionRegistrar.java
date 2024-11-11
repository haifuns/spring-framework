package com.test.class0501_context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author haifuns
 * @date 2024-11-11 16:12
 */
@Slf4j
public class DemoImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
		log.info("DemoImportBeanDefinitionRegistrar registerBeanDefinitions");
		BeanDefinitionBuilder bean = BeanDefinitionBuilder.genericBeanDefinition(BeanA.class);
		registry.registerBeanDefinition("beanA", bean.getBeanDefinition());
	}
}
