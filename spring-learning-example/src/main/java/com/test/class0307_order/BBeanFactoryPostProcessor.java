package com.test.class0307_order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
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
@Order(5)
@Slf4j
public class BBeanFactoryPostProcessor implements BeanFactoryPostProcessor, InitializingBean {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		int orderValue = 0;
		if (this.getClass().isAnnotationPresent(Order.class)) {
			orderValue = this.getClass().getAnnotation(Order.class).value();
		}
		log.info("execute postProcessBeanFactory 方法，order: {}", orderValue);
	}

	public BBeanFactoryPostProcessor() {
		log.info("BBeanFactoryPostProcessor 构造方法，order: {}", this.getClass().getAnnotation(Order.class).value());
	}

	@PostConstruct
	public void init() {
		log.info("BBeanFactoryPostProcessor init 方法");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("BBeanFactoryPostProcessor afterPropertiesSet 方法");
	}
}
