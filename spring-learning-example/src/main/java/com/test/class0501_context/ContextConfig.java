package com.test.class0501_context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * @author haifuns
 * @date 2024-10-16 17:15
 */
@ComponentScan("com.test.class0501_context")
@Import(DemoImportBeanDefinitionRegistrar.class)
public class ContextConfig {
}
