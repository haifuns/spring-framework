package com.test.class0401_mybatis.service;

import java.util.List;
import java.util.Map;

/**
 * @author haifuns
 * @date 2024-10-11 19:03
 */
public interface TService {

	List<Map<String, Object>> queryList();

	Map<String, Object> queryMap(Integer id);
}
