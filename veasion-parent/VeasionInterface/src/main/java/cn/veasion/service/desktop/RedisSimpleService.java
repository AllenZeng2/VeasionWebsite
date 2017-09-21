package cn.veasion.service.desktop;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

/**
 *  Redis Simple Service.
 *  
 *  @author Veasion
 */
public interface RedisSimpleService {

	public void add(String key, Serializable obj, long timeout, TimeUnit timeUnit);
	
	public Serializable get(String key);
	
	public void delete(String key);
	
}
