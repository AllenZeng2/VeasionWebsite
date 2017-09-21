package cn.veasion.web.admin.desktop;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.veasion.bean.PageModel;
import cn.veasion.bean.RequestGrid;
import cn.veasion.bean.ResponseBean;
import cn.veasion.bean.ResponseGrid;
import cn.veasion.entity.desktop.VeasionUrl;
import cn.veasion.service.desktop.VeasionUrlService;

/**
 * Url Controller.
 * 
 * @author zhuowei.luo
 */
@RequestMapping("/admin/desktop/url")
@Controller
public class UrlController {

	@Autowired
	private VeasionUrlService urlService;
	
	@RequestMapping("/urlSearch")
	@ResponseBody
	public ResponseGrid<VeasionUrl> urlSearch(VeasionUrl url, RequestGrid grid){
		
		PageModel<VeasionUrl> pageModel=new PageModel<VeasionUrl>(url, grid.getPage(), grid.getPagesize());
		urlService.select(pageModel);
		
		return new ResponseGrid<>(pageModel);
	}
	
	@RequestMapping("/goUrlModify")
	public String goUrlModify(Integer id, HttpServletRequest request){
		if(id != null){
			VeasionUrl url=urlService.selectByPrimaryKey(id);
			request.setAttribute("url", url);
		}
		return "admin/desktop/urlModify";
	}
	
	
	@RequestMapping("/urlModify")
	public String urlModify(VeasionUrl url, HttpServletRequest request){
		if(url==null){
			request.setAttribute("message", "参数错误！");
			return ResponseBean.FAILURE_DESKTOP;
		}
		int count=0;
		if(url.getId() != null){
			// 修改
			count=urlService.updateByPrimaryKeySelective(url);
			request.setAttribute("tabid", "updateUrl");
		}else{
			// 添加
			url.setCreateDate(new Date());
			count=urlService.insertSelective(url);
			request.setAttribute("tabid", "addUrl");
		}
		return count > 0 ? ResponseBean.SUCCESS_DESKTOP : ResponseBean.FAILURE_DESKTOP;
	}
	
	@RequestMapping("/urlDelete")
	@ResponseBody
	public Integer urlDelete(Integer id){
		return urlService.deleteByPrimaryKey(id);
	}
	
}
