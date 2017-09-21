package cn.veasion.service.desktop;

import cn.veasion.entity.desktop.KeyValue;

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
