package cn.veasion.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.veasion.bean.PageModel;
import cn.veasion.bean.RequestGrid;
import cn.veasion.bean.ResponseGrid;
import cn.veasion.entity.DesktopCloumn;
import cn.veasion.service.DesktopCloumnService;

/**
 * Icon Controller.
 * 
 * @author zhuowei.luo
 */
@RequestMapping("/admin/icon")
@Controller
public class IconController {

	@Autowired
	private DesktopCloumnService desktopCloumnService;
	
	@RequestMapping("/iconSearch")
	@ResponseBody
	public ResponseGrid<DesktopCloumn> iconSearch(DesktopCloumn cloumn, RequestGrid grid){
		
		PageModel<DesktopCloumn> pageModel=new PageModel<DesktopCloumn>(cloumn, grid.getPage(), grid.getPagesize());
		desktopCloumnService.select(pageModel);
		
		return new ResponseGrid<>(pageModel);
	}
	
}
