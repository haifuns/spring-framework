package com.test.class0501_context;

import com.test.class0501_context.beandefinitionregistry.ManualBeanDefinitionRegistry;
import com.test.class0501_context.beandefinitionregistry.ParentBeanDefinitionRegistry;
import com.test.class0501_context.beanfactorypostprocessor.ManualBeanFactoryPostProcessor;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author haifuns
 * @date 2024-10-16 17:16
 */
public class ContextTest {

	@Test
	public void testBeanDefinitionMap() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ContextConfig.class);
		context.refresh();

		// spring中启动自动加载到beanDefinitionMap中的类，加载位置：
		// AnnotationConfigApplicationContext构造方法->
		// AnnotatedBeanDefinitionReader构造方法->
		// AnnotationConfigUtils#registerAnnotationConfigProcessors

		// 自带注册的5个类：
		// ConfigurationClassPostProcessor
		// AutowiredAnnotationBeanPostProcessor 解析@Autowired
		// CommonAnnotationBeanPostProcessor 解析@Resource
		// EventListenerMethodProcessor
		// DefaultEventListenerFactory

		// BeanDefinitionMap中存储扫描或内置的BeanDefinition信息，name -> BeanDefinition
	}

	@Test
	public void invokeBeanFactoryPostProcessor() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.addBeanFactoryPostProcessor(new ManualBeanDefinitionRegistry());
		context.addBeanFactoryPostProcessor(new ManualBeanFactoryPostProcessor());
		context.register(ContextConfig.class);
		context.refresh();

		// AbstractApplicationContext#invokeBeanFactoryPostProcessors 执行所有可靠的BeanFactoryPostProcessor

		// BeanFactoryPostProcessor
		// BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
	}


	@Test
	public void testBeanDefinitionRegistryOrder() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.addBeanFactoryPostProcessor(new ManualBeanDefinitionRegistry());
		context.addBeanFactoryPostProcessor(new ManualBeanFactoryPostProcessor());
		context.register(ContextConfig.class);
		context.refresh();

		// 执行顺序：先执行子类再执行父类，先执行api提供的，再执行内置实现了PriorityOrdered接口的，然后执行扫描出来或者动态beanDefinition添加的实现了Ordered接口的

		// ManualBeanDefinitionRegistry api提供的优先，不会重复执行
		// -> ConfigurationClassPostProcessor 内置，实现了PriorityOrdered接口
		// -> PriorityOrderBeanDefinitionRegistry 扫描bean，实现PriorityOrdered
		// -> NormalBeanDefinitionRegistry 扫描bean
		// -> ParentBeanDefinitionRegistry 扫描bean，注册ChildBeanDefinitionRegistry
		// -> ZBeanDefinitionRegistry 扫描bean
		// -> ChildBeanDefinitionRegistry
		//
		// -> ManualBeanFactoryPostProcessor
		// -> PriorityOrderedBeanFactoryPostProcessor
		// -> NormalBeanFactoryPostProcessor
		// -> ZBeanFactoryPostProcessor
	}

	@Test
	public void testBeanDefinitionRegistryOrder2() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.addBeanFactoryPostProcessor(new ParentBeanDefinitionRegistry());
		context.addBeanFactoryPostProcessor(new ManualBeanDefinitionRegistry());
		context.register(ContextConfig.class);
		context.refresh();

		// 执行顺序：
		//	ParentBeanDefinitionRegistry
		//	ManualBeanDefinitionRegistry
		//	PriorityOrderedBeanDefinitionRegistry
		//	ChildBeanDefinitionRegistry
		//	NormalBeanDefinitionRegistry
		//	ParentBeanDefinitionRegistry
		//	ZBeanDefinitionRegistry
	}

	@Test
	public void testImportBeanDefinitionRegistrarOrder() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.addBeanFactoryPostProcessor(new ManualBeanDefinitionRegistry());
		context.addBeanFactoryPostProcessor(new ManualBeanFactoryPostProcessor());
		context.register(ContextConfig.class);
		context.refresh();

		// BeanDefinitionRegistryPostProcessor 和 ImportBeanDefinitionRegistrar 的区别：
		// 1. ImportBeanDefinitionRegistrar 回调时可以获取到注解信息
		// 2. 执行时机：ImportBeanDefinitionRegistrar 早于 BeanDefinitionRegistryPostProcessor（除api提供）
		// 3. BeanDefinitionRegistryPostProcessor（除api提供）对一些bean的注册可能有些功能会失效比如 @Bean
		// 4. ImportBeanDefinitionRegistrar 没有(3)问题，因为他是在 ConfigurationClassPostProcessor 内部执行的
		// 5. 如果一定要动态注册 BeanDefinition，推荐使用 ImportBeanDefinitionRegistrar
		// 6. 如果除了动态添加 BeanDefinition 外，还需要对 BeanFactory 做一些全局设定，那么可以用 BeanDefinitionRegistryPostProcessor，因为他是一个bean工厂后置处理器

		// 不推荐使用 BeanFactoryPostProcessor 注册 BeanDefinition 原因：
		// BeanFactoryPostProcessor 的优先级比 BeanDefinitionRegistryPostProcessor 还要低，
		// 可能会注册一个不完整功能的 Bean，除非能确定没有那些特殊功能比如 @Bean
	}
}
