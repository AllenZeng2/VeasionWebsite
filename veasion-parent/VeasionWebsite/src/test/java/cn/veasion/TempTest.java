package cn.veasion;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.DesktopCloumn;
import cn.veasion.service.DesktopCloumnService;

/**
 * Temp Test.
 * 
 * @author zhuowei.luo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:web/spring-context.xml")
public class TempTest {

	@Resource
	private DesktopCloumnService desktopCloumnService;
	
	@Test
	public void desktop(){
		try{
			PageModel<DesktopCloumn> pageModel=new PageModel<>(1, 10);
			desktopCloumnService.select(pageModel);
			System.out.println(pageModel);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
