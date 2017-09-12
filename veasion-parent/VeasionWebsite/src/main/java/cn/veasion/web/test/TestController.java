package cn.veasion.web.test;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.DesktopCloumn;
import cn.veasion.service.DesktopCloumnService;

/**
 * Test. 
 * 
 * @author zhuowei.luo
 */
@RequestMapping("/test")
@Controller
public class TestController {

	@Autowired
	private DesktopCloumnService desktopCloumnService;
	
	@RequestMapping("/test1")
	public ModelAndView test1(){
		System.out.println("test1...");
		ModelAndView mv=new ModelAndView();
		mv.addObject("message", "test1...");
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/test2")
	public String test2(HttpServletRequest req){
		System.out.println("test2...");
		req.setAttribute("message", "test2...");
		return "index";
	}
	
	@RequestMapping("/test3")
	@ResponseBody
	public DesktopCloumn test3(){
		List<DesktopCloumn> list=desktopCloumnService.select(new PageModel<>(1, 1));
		return list!=null && !list.isEmpty() ? list.get(0) : null;
	}
	
}
