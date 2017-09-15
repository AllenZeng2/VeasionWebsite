package cn.veasion.web.admin;

import java.util.Date;
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
import cn.veasion.entity.Dictionary;
import cn.veasion.service.DictionaryService;

/**
 * Dictionary Controller.
 * 
 * @author zhuowei.luo
 */
@RequestMapping("/admin/dictionary")
@Controller
public class DictionaryController {

	@Autowired
	private DictionaryService dictionaryService;
	
	@RequestMapping("/dictionarySearch")
	@ResponseBody
	public ResponseGrid<Dictionary> dictionarySearch(Dictionary d, RequestGrid grid){
		PageModel<Dictionary> pageModel=new PageModel<Dictionary>(d, grid.getPage(), grid.getPagesize());
		dictionaryService.select(pageModel);
		return new ResponseGrid<>(pageModel);
	}
	
	@RequestMapping("/goDictionaryModify")
	public String goDictionaryModify(Integer id, HttpServletRequest request){
		if (id != null) {
			request.setAttribute("dictionary", dictionaryService.selectByPrimaryKey(id));
		}
		return "admin/dictionaryModify";
	}
	
	@RequestMapping("/dictionaryModify")
	public String dictionaryModify(Dictionary dictionary, HttpServletRequest request){
		if(dictionary==null){
			request.setAttribute("message", "参数错误！");
			return ResponseBean.FAILURE;
		}
		int count=0;
		if (dictionary.getId() != null) {
			// 修改
			count=dictionaryService.updateByPrimaryKeySelective(dictionary);
			request.setAttribute("tabid", "updateDictionary");
		}else{
			// 添加
			dictionary.setCreateDate(new Date());
			dictionary.setStatus(EntityBean.STATUS_USE);
			count=dictionaryService.insertSelective(dictionary);
			request.setAttribute("tabid", "addDictionary");
		}
		return count > 0 ? ResponseBean.SUCCESS : ResponseBean.FAILURE;
	}
	
	@RequestMapping("/dictionaryDelete")
	@ResponseBody
	public Integer dictionaryDelete(Integer id){
		return dictionaryService.deleteByPrimaryKey(id);
	}
	
}
