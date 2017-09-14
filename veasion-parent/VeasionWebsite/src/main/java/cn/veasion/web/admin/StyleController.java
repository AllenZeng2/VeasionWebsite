package cn.veasion.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.veasion.bean.PageModel;
import cn.veasion.bean.RequestGrid;
import cn.veasion.bean.ResponseGrid;
import cn.veasion.entity.DesktopStyle;
import cn.veasion.service.DesktopStyleService;

/**
 * Style Controller.
 * 
 * @author zhuowei.luo
 */
@RequestMapping("/admin/style")
@Controller
public class StyleController {
	
	@Autowired
	private DesktopStyleService desktopStyleService;
	
	@RequestMapping("/styleSearch")
	@ResponseBody
	public ResponseGrid<DesktopStyle> styleSearch(DesktopStyle style, RequestGrid grid) {
		
		PageModel<DesktopStyle> pageModel = new PageModel<DesktopStyle>(style, grid.getPage(), grid.getPagesize());
		desktopStyleService.select(pageModel);
		
		return new ResponseGrid<>(pageModel);
	}
	
}
