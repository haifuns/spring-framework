package com.test.class0701_scan.batis;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Set;

/**
 * @author haifuns
 * @date 2025-01-13 10:41
 */

/**
 * 1、注册一个Include过滤器，match方法永远返回true
 * 2、重写#isCandidateComponent匹配接口
 * 3、为了获取这一次扫描出来的BeanDefinition 需要重写#doScan
 */
public class MyMapperScanner extends ClassPathBeanDefinitionScanner {
	public MyMapperScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters) {
		super(registry, useDefaultFilters);
	}

	@Override
	protected void registerDefaultFilters() {
		TypeFilter typeFilter = new TypeFilter() {
			@Override
			public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
				return true;
			}
		};
		addIncludeFilter(typeFilter);
	}

	@Override
	public boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
		return beanDefinition.getMetadata().isInterface();
	}

	@Override
	protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
		return super.doScan(basePackages);
	}
}
