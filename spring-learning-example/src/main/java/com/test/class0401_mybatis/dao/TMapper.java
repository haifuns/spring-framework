package com.test.class0401_mybatis.dao;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author haifuns
 * @date 2024-10-11 19:02
 */
public interface TMapper {

	@Select("select * from test_table")
	public List<Map<String, Object>> queryList();

	@Select("select * from test_table where id = #{id}")
	public Map<String, Object> queryMap(Integer id);
}
