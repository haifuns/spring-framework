package com.test.class0302_dependson;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author haifuns
 * @date 2024/9/10 21:31
 */

public class DependsOnTest {

    @Test
    public void dependsOnTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.test.class0302_dependson");
        context.refresh();

        // 默认加载Bean顺序是按字符序，先A后B
        // @DependsOn注解指定一个Bean依赖于另外一个或多个Bean，被依赖的Bean会先初始化‌，先B后A
    }
}
