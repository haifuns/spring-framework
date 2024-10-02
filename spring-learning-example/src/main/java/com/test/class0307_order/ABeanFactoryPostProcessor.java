package com.test.class0307_order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author haifuns
 * @date 2024-10-02 17:54
 */
@Component
@Order(6)
@Slf4j
public class ABeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		int orderValue = 0;
		if (this.getClass().isAnnotationPresent(Order.class)) {
			orderValue = this.getClass().getAnnotation(Order.class).value();
		}
		log.info("execute postProcessBeanFactory 方法，order: {}", orderValue);
	}

	public ABeanFactoryPostProcessor() {
		log.info("ABeanFactoryPostProcessor 构造方法，order: {}", this.getClass().getAnnotation(Order.class).value());
	}

	@PostConstruct
	public void init() {
		log.info("ABeanFactoryPostProcessor init 方法，order: {}", this.getClass().getAnnotation(Order.class).value());
	}
}
