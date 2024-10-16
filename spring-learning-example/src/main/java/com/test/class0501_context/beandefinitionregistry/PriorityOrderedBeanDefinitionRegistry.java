package com.test.class0501_context.beandefinitionregistry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * @author haifuns
 * @date 2024-10-16 17:22
 */
@Slf4j
@Component
public class PriorityOrderedBeanDefinitionRegistry implements BeanDefinitionRegistryPostProcessor, PriorityOrdered {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		log.info("PriorityOrderedBeanDefinitionRegistry postProcessBeanDefinitionRegistry");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		log.info("PriorityOrderedBeanDefinitionRegistry postProcessBeanFactory");
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
