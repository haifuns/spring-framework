package com.test.class0304_autowire;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author haifuns
 * @date 2024/9/11 22:29
 */
@Slf4j
public class AutowireTest {

    /**
     * {@link org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor}
     * {@link org.springframework.beans.factory.support.DefaultListableBeanFactory#resolveDependency}
     */
    @Test
    public void autowireTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.test.class0304_autowire");
        context.refresh();

        AutowireI autowireI = context.getBean(AutowireA.class).getAutowireI();
        log.debug("autowireI：{}", autowireI);

        // @Autowired 先通过类型找，如果存在多个，再通过名字过滤。
        // @Autowired 源码入口：
        // AutowiredAnnotationBeanPostProcessor.AutowiredFieldElement#inject
        // AutowiredAnnotationBeanPostProcessor.AutowiredMethodElement#inject
    }
}
