package com.test.class0311_registerbean;

/**
 * @author haifuns
 * @date 2024-10-03 17:32
 */
public class ObjectStaticFactory {
	public static BeanA getBeanA() {
		return new BeanA("ObjectStaticFactory static method");
	}
}
