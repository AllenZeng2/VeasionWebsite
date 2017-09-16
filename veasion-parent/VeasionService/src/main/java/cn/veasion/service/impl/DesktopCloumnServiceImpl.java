package cn.veasion.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.DesktopCloumn;
import cn.veasion.mapper.DesktopCloumnMapper;
import cn.veasion.service.DesktopCloumnService;

/**
 *  Desktop Cloumn ServiceImpl.
 *  
 *  @author zhuowei.luo
 */

@Service("desktopCloumnService")
@Transactional
public class DesktopCloumnServiceImpl implements DesktopCloumnService{

	@Resource
	private DesktopCloumnMapper desktopCloumnMapper;
	
	public int deleteByPrimaryKey(Integer id) {
		int count=desktopCloumnMapper.deleteByPrimaryKey(id);
		if(count>0){
			desktopCloumnMapper.deleteStyleCloumn(id);
		}
		return count;
	}

	public int insert(DesktopCloumn record) {
		return desktopCloumnMapper.insert(record);
	}

	public int insertSelective(DesktopCloumn record) {
		return desktopCloumnMapper.insertSelective(record);
	}

	public DesktopCloumn selectByPrimaryKey(Integer id) {
		return desktopCloumnMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(DesktopCloumn record) {
		return desktopCloumnMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(DesktopCloumn record) {
		return desktopCloumnMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<DesktopCloumn> selectByStyleId(Integer styleId) {
		return desktopCloumnMapper.selectByStyleId(styleId);
	}
	
	public List<DesktopCloumn> select(PageModel<DesktopCloumn> pageModel) {
		pageModel.setCount(desktopCloumnMapper.count(pageModel));
		List<DesktopCloumn> list=desktopCloumnMapper.select(pageModel);
		pageModel.setResult(list);
		return list;
	}
	
}
