package cn.veasion.service.desktop.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.desktop.VeasionUrl;
import cn.veasion.mapper.desktop.VeasionUrlMapper;
import cn.veasion.service.desktop.VeasionUrlService;

@Service("veasionUrlService")
@Transactional("desktop")
public class VeasionUrlServiceImpl implements VeasionUrlService{

	@Autowired
	private VeasionUrlMapper veasionUrlMapper;
	
	@Override
	public int insert(VeasionUrl record) {
		return veasionUrlMapper.insert(record);
	}

	@Override
	public int insertSelective(VeasionUrl record) {
		return veasionUrlMapper.insertSelective(record);
	}

	@Override
	public VeasionUrl selectByPrimaryKey(Integer id) {
		return veasionUrlMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(VeasionUrl record) {
		return veasionUrlMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(VeasionUrl record) {
		return veasionUrlMapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return veasionUrlMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public List<VeasionUrl> selectByType(Integer type) {
		VeasionUrl url=new VeasionUrl();
		url.setType(type);
		return veasionUrlMapper.select(new PageModel<VeasionUrl>(url, 1, 50));
	}

	@Override
	public List<VeasionUrl> select(PageModel<VeasionUrl> pageModel) {
		pageModel.setCount(veasionUrlMapper.count(pageModel));
		List<VeasionUrl> result=veasionUrlMapper.select(pageModel);
		pageModel.setResult(result);
		return result;
	}
	
}
