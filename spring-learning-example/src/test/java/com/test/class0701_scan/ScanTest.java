package com.test.class0701_scan;

import com.test.class0701_scan.myscan.ScanBeanDefinitionRegistryPostProcessor;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author haifuns
 * @date 2025/1/8 21:24
 */
public class ScanTest {

    @Test
    public void testScan() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScanConfig.class);
        // 扫描执行时机：ConfigurationClassPostProcessor#postProcessBeanDefinitionRegistry
    }

	@Test
	public void testMyScan() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// 自定义扫描
		context.register(ScanBeanDefinitionRegistryPostProcessor.class);
		context.refresh();
	}

	@Test
	public void twoScanner() {
		// Spring内置两个扫描器
		// 1. AnnotationConfigApplicationContext构造方法创建，用于处理用户手动调用#scan扫描
		// 2. ConfigurationClassPostProcessor#postProcessBeanDefinitionRegistry创建，用于处理@ComponentScan，功能更丰富
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.test.class0701_scan");

		// Spring扫描流程：
		// 1. 实例化、初始化扫描器，初始化的时候默认注册了三个include过滤器
		// 2. 解析@ComponentScan注解得到包名
		// 3. 根据包名扫描所有的文件
		// 4. 遍历文件，通过ASM字节码技术读取文件信息，封装为MetadataReader对象
		// 5. 调用#isCandidateComponent，通过MetadataReader判断是否exclude、是否include
		// 6. 如果被include则实例化ScannedGenericBeanDeﬁnition对象
		// 7. 判断ScannedGenericBeanDeﬁnition是否接口是否抽象、是否加了LockUp注解等
		// 8. 如果正常则put到beanDeﬁnitionMap
	}
}
