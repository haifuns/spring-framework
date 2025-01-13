package com.test.class0701_scan.batis;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author haifuns
 * @date 2025-01-13 10:38
 */

@Retention(RetentionPolicy.RUNTIME)
@Import(MyImportBeanDefinitionRegistrarV2.class)
@Configuration
public @interface MyScanV2 {

	String value() default "";
}
