package cn.veasion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.VeasionUrl;
import cn.veasion.mapper.VeasionUrlMapper;
import cn.veasion.service.VeasionUrlService;

@Service("veasionUrlService")
@Transactional
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
	public List<VeasionUrl> select(PageModel<VeasionUrl> pageModel) {
		pageModel.setCount(veasionUrlMapper.count(pageModel));
		List<VeasionUrl> result=veasionUrlMapper.select(pageModel);
		return result;
	}
	
}
