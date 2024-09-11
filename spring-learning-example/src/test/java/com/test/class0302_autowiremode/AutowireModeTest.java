package com.test.class0302_autowiremode;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author haifuns
 * @date 2024/9/11 21:40
 */
public class AutowireModeTest {

    @Test
    public void autowireModeTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AutowireModeScanConfig.class);
        // 改变A的注入模型
        //context.register(ModelBeanFactoryPostProcessor.class);
        context.refresh();

        // 默认情况下使用默认的构造方法
        // 修改bean注入模型会影响实例化选择的构造方法
        // 涉及spring推断构造方法，先看看现象，之后看源码
    }

}
