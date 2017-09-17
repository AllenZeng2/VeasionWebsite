package cn.veasion.mapper;

import cn.veasion.entity.KeyValue;

public interface KeyValueMapper {

	int insert(KeyValue keyValue);
	
	int update(KeyValue keyValue);
	
	int delete(String key);
	
	KeyValue select(String key);
	
}
