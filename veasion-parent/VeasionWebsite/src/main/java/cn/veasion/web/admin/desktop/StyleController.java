package cn.veasion.web.admin.desktop;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.veasion.bean.EntityBean;
import cn.veasion.bean.PageModel;
import cn.veasion.bean.RequestGrid;
import cn.veasion.bean.ResponseBean;
import cn.veasion.bean.ResponseGrid;
import cn.veasion.entity.desktop.DesktopCloumn;
import cn.veasion.entity.desktop.DesktopStyle;
import cn.veasion.entity.desktop.VeasionUrl;
import cn.veasion.service.desktop.DesktopCloumnService;
import cn.veasion.service.desktop.DesktopStyleService;
import cn.veasion.service.desktop.VeasionUrlService;

/**
 * Style Controller.
 * 
 * @author zhuowei.luo
 */
@RequestMapping("/admin/desktop/style")
@Controller
public class StyleController {
	
	@Autowired
	private DesktopStyleService desktopStyleService;
	@Autowired
	private DesktopCloumnService desktopCloumnService;
	@Autowired
	private VeasionUrlService urlService;
	
	
	@RequestMapping("/styleSearch")
	@ResponseBody
	public ResponseGrid<DesktopStyle> styleSearch(DesktopStyle style, RequestGrid grid) {
		
		PageModel<DesktopStyle> pageModel = new PageModel<DesktopStyle>(style, grid.getPage(), grid.getPagesize());
		desktopStyleService.select(pageModel);
		
		return new ResponseGrid<>(pageModel);
	}
	
	@RequestMapping("/goStyleModify")
	public String goStyleModify(Integer id, HttpServletRequest request){
		if (id != null) {
			DesktopStyle style=desktopStyleService.selectByPrimaryKey(id);
			request.setAttribute("desktopStyle", style);
		}
		List<VeasionUrl> bgimgs=urlService.selectByType(VeasionUrl.TYPE_STYLE);
		request.setAttribute("bgimgs", bgimgs);
		
		List<DesktopCloumn> icons=desktopCloumnService.select(new PageModel<>(1, 50));
		request.setAttribute("icons", icons);
		
		return "admin/desktop/styleModify";
	}
	
	@RequestMapping("/styleModify")
	public String styleModify(DesktopStyle style, HttpServletRequest request){
		if(style==null){
			request.setAttribute("message", "参数错误！");
			return ResponseBean.FAILURE_DESKTOP;
		}
		int count=0;
		if(style.getId()!=null){
			// 修改
			count=desktopStyleService.updateByPrimaryKeySelective(style);
			request.setAttribute("tabid", "updateStyle");
		}else{
			// 新增
			style.setStatus(EntityBean.STATUS_STOP);
			style.setCreateDate(new Date());
			count=desktopStyleService.insertSelective(style);
			request.setAttribute("tabid", "addStyle");
		}
		return count > 0 ? ResponseBean.SUCCESS_DESKTOP : ResponseBean.FAILURE_DESKTOP;
	}
	
	@RequestMapping("/styleSwitchStatus")
	@ResponseBody
	public Integer styleSwitchStatus(Integer id){
		if(id==null){
			return 0;
		}else{
			return desktopStyleService.styleSwitchStatus(id);
		}
	}
	
	@RequestMapping("/styleDelete")
	@ResponseBody
	public Integer styleDelete(Integer id){
		return desktopStyleService.deleteByPrimaryKey(id);
	}
	
}
