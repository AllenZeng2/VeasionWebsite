package cn.veasion.web.user;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.veasion.entity.IpRecord;
import cn.veasion.service.IpRecordService;
import cn.veasion.util.Constant;
import cn.veasion.util.IpUtil;

/**
 * User Interceptor.
 * 
 * @author Veasion
 */
public class UserInterceptor implements HandlerInterceptor{
	
	@Autowired
	private IpRecordService ipRecordService;
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
		Object obj=req.getSession().getAttribute(Constant.USER_SESSION);
		if(obj==null){
			req.getSession().setAttribute(Constant.USER_SESSION, Constant.USER_SESSION);
			// ip来访记录
			new Thread(()->{
				String ip=IpUtil.getIpAddress(req);
				String area=IpUtil.getAreaByIp(ip);
				if(area!=null && "本地".equals(area)){
					return;
				}
				IpRecord ipRecord=new IpRecord();
				ipRecord.setIp(ip);
				ipRecord.setArea(area);
				ipRecord.setDate(new Date());
				ipRecord.setLine(1);
				ipRecordService.insertSelective(ipRecord);
			}).start();
		}
		return true;
	}
	
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception { }
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception { }
	
}
