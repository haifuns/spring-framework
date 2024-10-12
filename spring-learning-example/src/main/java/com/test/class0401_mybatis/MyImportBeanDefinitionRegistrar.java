package com.test.class0401_mybatis;

import com.test.class0401_mybatis.dao.TMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haifuns
 * @date 2024-10-12 11:16
 */
@Slf4j
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
	Map<String, BeanDefinition> map = new HashMap<>();

	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		//模拟扫描mapper
		scan();
		for (String key : map.keySet()) {
			AbstractBeanDefinition mapperBd = (AbstractBeanDefinition) map.get(key);
			Class mapperClz = mapperBd.getBeanClass();
			log.debug("before: {}", mapperBd.getBeanClass().getName());
			mapperBd.setBeanClass(MyFactoryBean.class);
			log.debug("after: {}", mapperBd.getBeanClass().getName());
			mapperBd.getPropertyValues().add("mapperInterface", mapperClz.getName());
			registry.registerBeanDefinition(key, mapperBd);
		}
	}

	public void scan() {
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(TMapper.class);
		map.put("tmapper", builder.getBeanDefinition());
	}
}
