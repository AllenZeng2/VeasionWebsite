package cn.veasion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.VeasionMusic;
import cn.veasion.mapper.VeasionMusicMapper;
import cn.veasion.service.VeasionMusicService;
import org.springframework.transaction.annotation.Transactional;

@Service("veasionMusicService")
@Transactional
public class VeasionMusicServiceImpl implements VeasionMusicService{

	@Autowired
	private VeasionMusicMapper veasionMusicMapper;
	
	@Override
	public int insert(VeasionMusic record) {
		return veasionMusicMapper.insert(record);
	}

	@Override
	public int insertSelective(VeasionMusic record) {
		return veasionMusicMapper.insertSelective(record);
	}

	@Override
	public VeasionMusic selectByPrimaryKey(Integer id) {
		return veasionMusicMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(VeasionMusic record) {
		return veasionMusicMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(VeasionMusic record) {
		return veasionMusicMapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return veasionMusicMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void click(Integer id) {
		veasionMusicMapper.click(id);
	}
	
	@Override
	public List<VeasionMusic> select(PageModel<VeasionMusic> pageModel) {
		pageModel.setCount(veasionMusicMapper.count(pageModel));
		List<VeasionMusic> result=veasionMusicMapper.select(pageModel);
		pageModel.setResult(result);
		return result;
	}
	
}