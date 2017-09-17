package cn.veasion.service;

import cn.veasion.entity.KeyValue;

/**
 * Key Value Service.
 * 
 * @author Veasion
 */
public interface KeyValueService {

	int insert(KeyValue keyValue);
	
	int update(KeyValue keyValue);
	
	int delete(String key);
	
	KeyValue select(String key);
	
}
