package com.test.class0401_mybatisdesign;

import com.test.class0401_mybatis.MySqlSession;
import com.test.class0401_mybatis.MybatisConfig;
import com.test.class0401_mybatis.dao.TMapper;
import com.test.class0401_mybatis.service.TService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
		log.debug("resultList:{}", resultList);
	}

	/**
	 * 测试单独试用mybatis
	 */
	@Test
	public void onlyBatis() {
//		BatisConfig config  = new BatisConfig();
//
//		DataSource dataSource = config.dataSource();
//		TransactionFactory transactionFactory =
//				new JdbcTransactionFactory();
//		Environment environment =
//				new Environment("development", transactionFactory, dataSource);
//		Configuration configuration = new Configuration(environment);
//
//
//		configuration.addMapper(TMapper.class);
//
//
//		SqlSessionFactory sqlSessionFactory =
//				new SqlSessionFactoryBuilder().build(configuration);
//
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//
//		//对象 本来是一个接口
//		//有可能完成了 TMapper接口的实例化
//		//动态代理
//		TMapper mapper = sqlSession.getMapper(TMapper.class);
//		//queryFroMap?
//		Map<String, Object> resultMap = mapper.queryFroMap(1);
//		log.debug("resultMap:{}",resultMap);
	}


	/**
	 * 测试山寨版的 mybatis
	 */
	@Test
	public void customBatis() {
		TMapper mapper = (TMapper) MySqlSession.getMapper(TMapper.class);
		mapper.queryMap(1);
		mapper.queryList();
	}

	/**
	 * 测试把一个第三方的对象给spring
	 * <p>
	 * 1、注解（@Service....） X
	 * 2、<bean id="n"></bean> X
	 * 3、注解（@Bean）
	 * 4、factoryBean
	 * 5、spring api
	 * 6、动态想容器注册beandefinition X
	 */
	@Test
	public void customObjectBatis() {
		//一定要mybatis产生？
		//只有他自己知道要干什么事情


		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MybatisConfig.class);

		TService service = context.getBean(TService.class);
		service.queryList();
	}

	@Test
	public void beanDefinitionBatis() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();
		context.scan("com.test.class0401_mybatis.bean");
		context.refresh();

		//Object d = context.getBean(X.class);
	}

	/**
	 * 测试ImportBeanDefinitionRegistrar
	 */
	@Test
	public void importBeanDefinitionRegistrarBatis() {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MybatisConfig.class);

//		TService bean = context.getBean(TService.class);
//		bean.queryFroList();
//		AMapper aMapper = (AMapper) context.getBean("amapper");
//		aMapper.queryFroMap(1);
//
//		TMapper tMapper = (TMapper) context.getBean("tmapper");
//		tMapper.queryFroList();
//		Object d = context.getBean(X.class);
	}


//	@Test
//	public void test(){
//		TMapper mapper = (TMapper) MySqlSession.getMapper(TMapper.class);
//		mapper.queryFroList();
//	}
}
