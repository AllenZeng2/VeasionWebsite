package cn.veasion.web.admin;

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
import cn.veasion.entity.DesktopCloumn;
import cn.veasion.entity.VeasionUrl;
import cn.veasion.service.DesktopCloumnService;
import cn.veasion.service.VeasionUrlService;

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
	@Autowired
	private VeasionUrlService urlService;
	
	
	@RequestMapping("/iconSearch")
	@ResponseBody
	public ResponseGrid<DesktopCloumn> iconSearch(DesktopCloumn cloumn, RequestGrid grid){
		
		PageModel<DesktopCloumn> pageModel=new PageModel<DesktopCloumn>(cloumn, grid.getPage(), grid.getPagesize());
		desktopCloumnService.select(pageModel);
		
		return new ResponseGrid<>(pageModel);
	}
	
	@RequestMapping("/goIconModify")
	public String goIconModify(Integer id, HttpServletRequest request){
		if(id != null){
			DesktopCloumn cloumn=desktopCloumnService.selectByPrimaryKey(id);
			request.setAttribute("icon", cloumn);
		}
		
		request.setAttribute("showTypes", DesktopCloumn.SHOW_TYPES);
		
		List<VeasionUrl> icons=urlService.selectByType(VeasionUrl.TYPE_ICON);
		request.setAttribute("icons", icons);
		
		List<VeasionUrl> urls=urlService.selectByType(VeasionUrl.TYPE_URL);
		request.setAttribute("urls", urls);
		
		return "admin/iconModify";
	}
	
	@RequestMapping("/iconUpdate")
	public String iconUpdate(DesktopCloumn cloumn, HttpServletRequest request){
		if(cloumn==null){
			request.setAttribute("message", "参数不能为空！");
			return ResponseBean.FAILURE;
		}
		int count=0;
		if(cloumn.getId() != null){
			// 修改
			count=desktopCloumnService.updateByPrimaryKeySelective(cloumn);
			request.setAttribute("tabid", "updateIcon");
		}else{
			// 添加
			cloumn.setCreateDate(new Date());
			cloumn.setStatus(EntityBean.STATUS_USE);
			count=desktopCloumnService.insertSelective(cloumn);
			request.setAttribute("tabid", "addIcon");
		}
		return count > 0 ? ResponseBean.SUCCESS : ResponseBean.FAILURE;
	}
	
	
	@RequestMapping("/iconDelete")
	@ResponseBody
	public Integer iconDelete(Integer id){
		return desktopCloumnService.deleteByPrimaryKey(id);
	}
	
}
