package com.test.class0401_mybatis;

import com.test.class0401_mybatis.dao.TMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @author haifuns
 * @date 2024-10-11 19:01
 */
@Configuration
@ComponentScan("com.test.class0401_mybatis")
//@MapperScan("com.test.class0401_mybatis.dao")
//@ImportResource("classpath:spring-mybatis.xml")
//@Import(MyImportBeanDefinitionRegistrar.class)
@MyScan
public class MybatisConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("org.h2.Driver");
		driverManagerDataSource.setUrl("jdbc:h2:mem:test-db;DB_CLOSE_DELAY=-1");
		driverManagerDataSource.setUsername("sa");
		driverManagerDataSource.setPassword("");
		return driverManagerDataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		return factoryBean.getObject();
	}

	//@Bean
	public MapperFactoryBean<TMapper> userMapper() throws Exception {
		MapperFactoryBean<TMapper> factoryBean = new MapperFactoryBean<>(TMapper.class);
		factoryBean.setSqlSessionFactory(sqlSessionFactory());
		return factoryBean;
	}

	//@Bean
	public TMapper tMapper() {
		return (TMapper) MySqlSession.getMapper(TMapper.class);
	}
}
