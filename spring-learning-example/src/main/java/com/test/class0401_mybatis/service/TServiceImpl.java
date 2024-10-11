package com.test.class0401_mybatis.service;

import com.test.class0401_mybatis.dao.TMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author haifuns
 * @date 2024-10-11 19:04
 */
@Service
public class TServiceImpl implements TService {

	@Autowired
	private TMapper tMapper;

	@Override
	public List<Map<String, Object>> queryList() {
		return tMapper.queryList();
	}


	@Override
	public Map<String, Object> queryMap(Integer id) {
		return tMapper.queryMap(id);
	}
}
