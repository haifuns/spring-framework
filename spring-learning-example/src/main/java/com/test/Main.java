package com.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author haifuns
 * @date 2024/1/18 22:52
 */
public class Main {

	public static void main(String[] args) {
		// 运行报错，core/context kotlin类找不到时，到对应项目test/java/example文件夹右键执行单元测试即可
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(Bean.class);
		context.refresh();
		System.out.println(context.getBean(Bean.class));


//		ClassPathResource resource = new ClassPathResource("bean.xml");
//		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
//		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
//		reader.loadBeanDefinitions(resource);
//		factory.getBean("");
	}
}