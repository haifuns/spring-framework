package com.test.class0401_mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author haifuns
 * @date 2024-10-11 19:07
 */
public class MySqlSession {
	/**
	 * 必须返回一个对象
	 * 对象：
	 * 1、实现clazz接口
	 * 2、实现clazz接口当中的所有方法
	 * 3、这些方法的逻辑需要完成对改方法上面的sql语句的执行
	 * (ClassLoader loader,
	 * Class<?>[] interfaces,
	 * InvocationHandler h
	 *
	 * @param clazz
	 * @return
	 */
	public static Object getMapper(Class clazz) {
		ClassLoader classLoader = MySqlSession.class.getClassLoader();
		return Proxy.newProxyInstance(classLoader, new Class[]{clazz}, new MyTestInvocationHandler());
	}

	@Slf4j
	static class MyTestInvocationHandler implements InvocationHandler {
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			//处理toString、hashcode等Object方法
			if (method.getDeclaringClass().equals(Object.class)) {
				method.invoke(this, args);
			}

			//
			Select select = method.getAnnotation(Select.class);
			String sql = select.value()[0];
			log.debug("模拟连接数据库");
			log.debug("模拟执行查询，sql: {}", sql);
			log.debug("模拟返回查询结果");
			return null;
		}
	}
}
