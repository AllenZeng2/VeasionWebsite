package cn.veasion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.DesktopStyle;
import cn.veasion.mapper.DesktopCloumnMapper;
import cn.veasion.mapper.DesktopStyleMapper;
import cn.veasion.service.DesktopStyleService;
import cn.veasion.util.VeaUtil;

@Service("desktopStyleService")
@Transactional
public class DesktopStyleServiceImpl implements DesktopStyleService{

	@Autowired
	private DesktopStyleMapper desktopStyleMapper;
	@Autowired
	private DesktopCloumnMapper desktopCloumnMapper;
	
	@Override
	public int insert(DesktopStyle record) {
		return desktopStyleMapper.insert(record);
	}

	@Override
	public int insertSelective(DesktopStyle record) {
		return desktopStyleMapper.insertSelective(record);
	}

	@Override
	public DesktopStyle selectByPrimaryKey(Integer id) {
		DesktopStyle style= desktopStyleMapper.selectByPrimaryKey(id);
		if(style!=null && style.getId() !=null){
			style.setDesktopCloumns(desktopCloumnMapper.selectByStyleId(style.getId()));
		}
		return style;
	}

	@Override
	public int updateByPrimaryKeySelective(DesktopStyle record) {
		return desktopStyleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(DesktopStyle record) {
		return desktopStyleMapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return desktopStyleMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public DesktopStyle selectForInUse() {
		PageModel<DesktopStyle> pageModel=new PageModel<>(1, 1);
		DesktopStyle style=new DesktopStyle();
		style.setStatus(DesktopStyle.STATUS_USE);
		pageModel.setObj(style);
		List<DesktopStyle> styles=desktopStyleMapper.select(pageModel);
		if(!VeaUtil.isNullEmpty(styles)){
			style=styles.get(0);
			if(style!=null && style.getId()!=null){
				style.setDesktopCloumns(desktopCloumnMapper.selectByStyleId(style.getId()));
			}
			return style;
		}else{
			return null;
		}
	}
	
	@Override
	public List<DesktopStyle> select(PageModel<DesktopStyle> pageModel) {
		pageModel.setCount(desktopStyleMapper.count(pageModel));
		List<DesktopStyle> result=desktopStyleMapper.select(pageModel);
		if(!VeaUtil.isNullEmpty(result)){
			for (DesktopStyle style : result) {
				if(style!=null && style.getId()!=null){
					style.setDesktopCloumnIds(desktopStyleMapper.selectDesktopCloumnIds(style.getId()));
				}
			}
		}
		pageModel.setResult(result);
		return result;
	}

}
