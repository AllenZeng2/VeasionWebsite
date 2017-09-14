package cn.veasion.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.veasion.bean.PageModel;
import cn.veasion.bean.RequestGrid;
import cn.veasion.bean.ResponseGrid;
import cn.veasion.entity.VeasionUrl;
import cn.veasion.service.VeasionUrlService;

/**
 * Url Controller.
 * 
 * @author zhuowei.luo
 */
@RequestMapping("/admin/url")
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
	
}
