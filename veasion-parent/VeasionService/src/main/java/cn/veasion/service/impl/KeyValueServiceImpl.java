package cn.veasion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.veasion.entity.KeyValue;
import cn.veasion.mapper.KeyValueMapper;
import cn.veasion.service.KeyValueService;

@Service("KeyValueService")
@Transactional
public class KeyValueServiceImpl implements KeyValueService{

	@Autowired
	private KeyValueMapper keyValueMapper;
	
	@Override
	public int insert(KeyValue keyValue) {
		return keyValueMapper.insert(keyValue);
	}

	@Override
	public int update(KeyValue keyValue) {
		return keyValueMapper.update(keyValue);
	}

	@Override
	public int delete(String key) {
		return keyValueMapper.delete(key);
	}

	@Override
	public KeyValue select(String key) {
		return keyValueMapper.select(key);
	}

}
