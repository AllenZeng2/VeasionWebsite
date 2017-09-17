package cn.veasion.service.impl;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.veasion.service.RedisSimpleService;

@Service("redisSimpleService")
@Transactional
public class RedisSimpleServiceImpl implements RedisSimpleService{

	@Resource
	private RedisTemplate<String, Serializable> redisTemplate;
	
	@Override
	public void add(String key, Serializable obj, long timeout, TimeUnit timeUnit) {
		if(redisTemplate.hasKey(key)){
			delete(key);
		}
		redisTemplate.opsForValue().set(key, obj, timeout, timeUnit);
	}

	@Override
	public Serializable get(String key) {
		try{
			return redisTemplate.opsForValue().get(key);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void delete(String key) {
		redisTemplate.delete(key);
	}
	
}
