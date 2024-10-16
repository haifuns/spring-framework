package com.test.class0501_context.beandefinitionregistry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author haifuns
 * @date 2024-10-16 17:09
 */
@Slf4j
@Component
public class ParentBeanDefinitionRegistry implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		log.info("ParentBeanDefinitionRegistry postProcessBeanDefinitionRegistry，register ChildABeanDefinitionRegistry");

		BeanDefinitionBuilder childA = BeanDefinitionBuilder.genericBeanDefinition(ChildBeanDefinitionRegistry.class);
		registry.registerBeanDefinition("childABeanDefinitionRegistry", childA.getBeanDefinition());
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		log.info("ParentBeanDefinitionRegistry postProcessBeanFactory");
	}
}
