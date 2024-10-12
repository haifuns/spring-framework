package com.test.class0401_mybatis;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author haifuns
 * @date 2024-10-12 11:16
 */
public class MyFactoryBean implements FactoryBean {

	Class mapperInterface;

	public void setMapperInterface(Class mapperInterface) {
		this.mapperInterface = mapperInterface;
	}

	@Override
	public Object getObject() throws Exception {
		return MySqlSession.getMapper(mapperInterface);
	}

	@Override
	public Class<?> getObjectType() {
		return mapperInterface;
	}
}
