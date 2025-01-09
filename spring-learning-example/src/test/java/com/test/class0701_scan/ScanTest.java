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
}
