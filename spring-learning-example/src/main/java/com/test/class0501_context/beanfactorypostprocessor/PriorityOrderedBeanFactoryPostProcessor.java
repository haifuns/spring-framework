package com.test.class0501_context.beanfactorypostprocessor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * @author haifuns
 * @date 2024-10-16 19:39
 */
@Slf4j
@Component
public class PriorityOrderedBeanFactoryPostProcessor implements BeanFactoryPostProcessor, PriorityOrdered {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		log.info("PriorityOrderedBeanFactoryPostProcessor postProcessBeanFactory");
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
