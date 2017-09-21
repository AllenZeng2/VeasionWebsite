package cn.veasion.website;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.veasion.service.website.TestService;

/**
 * Mybatis Test.
 * 
 * @author zhuowei.luo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:web/spring-context.xml")
public class MybatisTest {

	@Autowired
	private TestService testService;
	
	@Test
	public void test(){
		System.out.println(testService.select());
	}
	
}
