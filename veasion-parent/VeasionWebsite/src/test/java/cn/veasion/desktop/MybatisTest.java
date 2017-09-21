package cn.veasion.desktop;

import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cn.veasion.bean.PageModel;
import cn.veasion.service.desktop.DesktopCloumnService;
import cn.veasion.service.desktop.DesktopStyleService;
import cn.veasion.service.desktop.IpRecordService;
import cn.veasion.service.desktop.VeasionMusicService;
import cn.veasion.service.desktop.VeasionUrlService;

/**
 * Mybatis Test.
 * 
 * @author zhuowei.luo
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:web/spring-context.xml")
public class MybatisTest {

	@Resource
	private DesktopCloumnService desktopCloumnService;
	@Resource
	private DesktopStyleService desktopStyleService;
	@Resource
	private IpRecordService ipRecordService;
	@Resource
	private VeasionMusicService veasionMusicService;
	@Resource
	private VeasionUrlService veasionUrlService;
	
	@Test
	public void desktop(){
		try{
			
			desktopCloumnService.select(new PageModel<>(1, 10));
			
			desktopStyleService.select(new PageModel<>(1, 10));
			
			ipRecordService.select(new PageModel<>(1, 10));
			
			veasionMusicService.select(new PageModel<>(1, 10));
			
			veasionUrlService.select(new PageModel<>(1, 10));
			
			System.out.println(desktopStyleService.selectForInUse());;
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
