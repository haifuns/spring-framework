package com.test.class0701_scan.myscan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

import java.util.List;
import java.util.Map;

/**
 * @author haifuns
 * @date 2025-01-09 10:32
 */
@Slf4j
public class ScanBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		try {
			MyScanner myScanner = new MyScanner();
			// 自定义模拟扫描
			myScanner.scan("com.test.class0701_scan");

			List<String> listName = myScanner.getListName();
			Map<String, AbstractBeanDefinition> map = myScanner.getMap();

			for (String s : listName) {
				registry.registerBeanDefinition(s, map.get(s));
			}
		} catch (ClassNotFoundException e) {
			log.error("扫描类失败", e);
		}
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}
}
