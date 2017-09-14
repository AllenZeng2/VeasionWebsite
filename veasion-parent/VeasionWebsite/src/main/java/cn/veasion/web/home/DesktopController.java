package cn.veasion.web.home;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.veasion.entity.DesktopStyle;
import cn.veasion.service.DesktopStyleService;
import cn.veasion.service.UserService;
import cn.veasion.util.Constant;

/**
 * Desktop Controller.
 * 
 * @author zhuowei.luo
 */
@RequestMapping("/home/desktop")
@Controller
public class DesktopController {

	@Autowired
	private DesktopStyleService desktopStyleService;
	@Autowired
	private UserService userService;
	
	/**
	 * 加载正在使用的桌面数据 
	 */
	@RequestMapping("/loadDesktopData")
	@ResponseBody
	public DesktopStyle loadDesktopData(){
		return desktopStyleService.selectForInUse();
	}
	
	/**
	 * 管理员暗码验证. 
	 */
	@RequestMapping("/adminValidation")
	@ResponseBody
	public Boolean adminValidation(String value, HttpServletRequest request){
		System.out.println(value);
		if(userService.login(value)){
			request.getSession().setAttribute(Constant.ADMIN_SESSION, Constant.ADMIN_SESSION);
			return true;
		}else{
			return false;
		}
	}
	
}
