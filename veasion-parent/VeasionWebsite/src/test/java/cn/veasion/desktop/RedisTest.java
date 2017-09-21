package cn.veasion.desktop;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.veasion.service.desktop.RedisSimpleService;

/**
 * Redis Test.
 * 
 * @author zhuowei.luo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:web/spring-context.xml")
public class RedisTest {

	@Autowired
	private RedisSimpleService redisSimpleService;
	
	@Test
	public void test(){
		try{
			redisSimpleService.add("name", "Veasion", 1, TimeUnit.MINUTES);
			String value=(String)redisSimpleService.get("name");
			System.out.println(value);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
