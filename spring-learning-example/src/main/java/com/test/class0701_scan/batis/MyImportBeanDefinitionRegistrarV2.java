package com.test.class0701_scan.batis;

import com.test.class0401_mybatis.MyFactoryBean;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;
import java.util.Set;

/**
 * @author haifuns
 * @date 2025-01-13 10:39
 */
public class MyImportBeanDefinitionRegistrarV2 implements ImportBeanDefinitionRegistrar {

	Set<BeanDefinitionHolder> beanDefinitionHolders = null;

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(MyScanV2.class.getName());
		this.scan(registry, annotationAttributes);
		for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
			AbstractBeanDefinition mapperBd = (AbstractBeanDefinition) beanDefinitionHolder.getBeanDefinition();
			String beanClassName = mapperBd.getBeanClassName();
			mapperBd.setBeanClass(MyFactoryBean.class);
			mapperBd.getPropertyValues().add("mapperInterface", beanClassName);
		}
	}

	public void scan(BeanDefinitionRegistry registry, Map<String, Object> annotationAttributes) {
		String scanPackageName = (String) annotationAttributes.get("value");
		MyMapperScanner scanner = new MyMapperScanner(registry, true);
		beanDefinitionHolders = scanner.doScan(scanPackageName);
	}
}
