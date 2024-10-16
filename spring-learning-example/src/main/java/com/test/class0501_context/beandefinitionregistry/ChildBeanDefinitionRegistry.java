package com.test.class0501_context.beandefinitionregistry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * @author haifuns
 * @date 2024-10-16 17:09
 */
@Slf4j
public class ChildBeanDefinitionRegistry implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		log.info("ChildBeanDefinitionRegistry postProcessBeanDefinitionRegistry");
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		log.info("ChildBeanDefinitionRegistry postProcessBeanFactory");
	}
}
