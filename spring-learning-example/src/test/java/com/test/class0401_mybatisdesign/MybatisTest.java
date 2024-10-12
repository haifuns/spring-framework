package com.test.class0401_mybatisdesign;

import com.test.class0401_mybatis.MySqlSession;
import com.test.class0401_mybatis.MybatisConfig;
import com.test.class0401_mybatis.dao.TMapper;
import com.test.class0401_mybatis.service.TService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

/**
 * @author haifuns
 * @date 2024-10-11 19:05
 */
@Slf4j
public class MybatisTest {

	@Before
	public void initTable() throws SQLException {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MybatisConfig.class);
		SqlSessionFactory sqlSessionFactory = context.getBean(SqlSessionFactory.class);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			Connection connection = sqlSession.getConnection();
			Statement statement = connection.createStatement();
			// 创建表
			statement.execute("CREATE TABLE IF NOT EXISTS test_table(id int primary key, name varchar(255))");
			// 清空表数据
			statement.execute("DELETE FROM test_table");
			// 插入数据
			statement.execute("INSERT INTO test_table(id, name) VALUES (10001, '张三')");
			statement.execute("INSERT INTO test_table(id, name) VALUES (10002, '李四')");
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			sqlSession.close();
		}
	}

	/**
	 * 测试整合mybatis
	 */
	@Test
	public void defaultBatis() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MybatisConfig.class);
		TService service = context.getBean(TService.class);
		List<Map<String, Object>> resultList = service.queryList();
		log.debug("resultList: {}", resultList);
	}

	/**
	 * 测试单独使用mybatis
	 */
	@Test
	public void onlyMybatis() {
		MybatisConfig config = new MybatisConfig();
		DataSource dataSource = config.dataSource();
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);

		configuration.addMapper(TMapper.class);

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 底层使用jdk动态代理 MapperProxyFactory#newInstance
		TMapper mapper = sqlSession.getMapper(TMapper.class);
		Map<String, Object> resultMap = mapper.queryMap(10001);
		log.debug("resultMap: {}", resultMap);
	}


	/**
	 * 模拟 mybatis
	 */
	@Test
	public void mockMybatis() {
		TMapper mapper = (TMapper) MySqlSession.getMapper(TMapper.class);
		mapper.queryList();
	}

	/**
	 * 注册mapper到spring
	 * <p>
	 * <a href="https://mybatis.org/spring/mappers.html">官方文档</a>
	 * <p>
	 */
	@Test
	public void registerMapper() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MybatisConfig.class);
		TService service = context.getBean(TService.class);
		service.queryList();

		// 1.MapperFactoryBean -> 模拟实现MyFactoryBean，底层使用动态代理
		// 2.<mybatis:scan> / @MapperScan -> 模拟实现@MyScan，MyImportBeanDefinitionRegistrar
	}
}
