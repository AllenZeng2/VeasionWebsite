package cn.veasion.handle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import cn.veasion.util.Constant;

/**
 * Admin Interceptor.
 * 
 * @author Veasion
 */
public class AdminInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// admin未登录拦截
		Object admin=request.getSession().getAttribute(Constant.ADMIN_SESSION);
		if(admin==null || !Constant.ADMIN_SESSION.equals(admin)){
			response.sendError(404);
			return false;
		}else{
			return true;
		}
	}
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception { }

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception { }

}
