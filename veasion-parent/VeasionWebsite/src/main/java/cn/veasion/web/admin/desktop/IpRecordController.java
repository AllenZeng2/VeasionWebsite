package cn.veasion.web.admin.desktop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.veasion.bean.PageModel;
import cn.veasion.bean.RequestGrid;
import cn.veasion.bean.ResponseGrid;
import cn.veasion.entity.desktop.IpRecord;
import cn.veasion.service.desktop.IpRecordService;

/**
 *  Ip Record Controller.
 *  
 *  @author Veasion
 */
@RequestMapping("/admin/desktop/ip")
@Controller
public class IpRecordController {

	@Autowired
	private IpRecordService ipRecordService;
	
	@RequestMapping("/ipSearch")
	@ResponseBody
	public ResponseGrid<IpRecord> styleSearch(IpRecord ip, RequestGrid grid) {
		PageModel<IpRecord> pageModel = new PageModel<IpRecord>(ip, grid.getPage(), grid.getPagesize());
		pageModel.setOrderBy(IpRecord.ORDER_BY_DATE);
		pageModel.setDesc(true);
		ipRecordService.select(pageModel);
		return new ResponseGrid<>(pageModel);
	}
	
	@RequestMapping("ipDelete")
	@ResponseBody
	public Integer ipDelete(Integer id){
		return ipRecordService.deleteByPrimaryKey(id);
	}
	
}
