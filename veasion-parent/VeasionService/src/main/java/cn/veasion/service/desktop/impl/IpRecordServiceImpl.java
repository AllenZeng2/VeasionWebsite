package cn.veasion.service.desktop.impl;

import org.springframework.transaction.annotation.Transactional;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.desktop.IpRecord;
import cn.veasion.mapper.desktop.IpRecordMapper;
import cn.veasion.service.desktop.IpRecordService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ipRecordService")
@Transactional("desktop")
public class IpRecordServiceImpl implements IpRecordService{

	@Autowired
	private IpRecordMapper ipRecordMapper;
	
	@Override
	public int insert(IpRecord record) {
		return ipRecordMapper.insert(record);
	}

	@Override
	public int insertSelective(IpRecord record) {
		return ipRecordMapper.insertSelective(record);
	}

	@Override
	public IpRecord selectByPrimaryKey(Integer id) {
		return ipRecordMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(IpRecord record) {
		return ipRecordMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(IpRecord record) {
		return ipRecordMapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return ipRecordMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int count(IpRecord ip) {
		PageModel<IpRecord> pm=new PageModel<>();
		pm.setObj(ip);
		return ipRecordMapper.count(pm);
	}
	
	@Override
	public List<IpRecord> select(PageModel<IpRecord> pageModel) {
		pageModel.setCount(ipRecordMapper.count(pageModel));
		List<IpRecord> result=ipRecordMapper.select(pageModel);
		pageModel.setResult(result);
		return result;
	}
	
}
