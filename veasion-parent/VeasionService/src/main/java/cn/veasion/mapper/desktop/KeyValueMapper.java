package cn.veasion.mapper.desktop;

import cn.veasion.entity.desktop.KeyValue;

public interface KeyValueMapper {

	int insert(KeyValue keyValue);
	
	int update(KeyValue keyValue);
	
	int delete(String key);
	
	KeyValue select(String key);
	
}
