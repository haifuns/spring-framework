package com.test.class0311_registerbean;

/**
 * @author haifuns
 * @date 2024-10-03 17:39
 */
public class SupplierFactory {
	public static BeanA getObject() {
		return new BeanA("SupplierFactory method");
	}
}
