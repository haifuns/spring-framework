package com.test.class0311_registerbean;

/**
 * @author haifuns
 * @date 2024-10-03 17:31
 */
public class ObjectFactory {
	public BeanA instanceObject() {
		return new BeanA("ObjectFactory method");
	}
}
