package cn.veasion.service.website.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.veasion.entity.website.Test;
import cn.veasion.mapper.website.TestMapper;
import cn.veasion.service.website.TestService;

@Service
@Transactional("website")
public class TestServiceImpl implements TestService {

	@Autowired
	private TestMapper testMapper;
	
	@Override
	public int insert(Test record) {
		return testMapper.insert(record);
	}

	@Override
	public int insertSelective(Test record) {
		return testMapper.insertSelective(record);
	}

	@Override
	public List<Test> select() {
		return testMapper.select();
	}

	@Override
	public int updateByPrimaryKeySelective(Test record) {
		return testMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Test record) {
		return testMapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return testMapper.deleteByPrimaryKey(id);
	}

}
