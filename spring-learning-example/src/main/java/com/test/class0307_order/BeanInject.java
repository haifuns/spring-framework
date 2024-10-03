package com.test.class0307_order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author haifuns
 * @date 2024-10-03 16:00
 */
@Component("a")
public class BeanInject {

	private List<BeanElement> beanFactoryPostProcessor;

	@Autowired
	public void setBeanFactoryPostProcessor(List<BeanElement> beanFactoryPostProcessor) {
		this.beanFactoryPostProcessor = beanFactoryPostProcessor;
	}

	public List<BeanElement> getBeanFactoryPostProcessor() {
		return beanFactoryPostProcessor;
	}
}
