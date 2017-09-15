package cn.veasion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.Dictionary;
import cn.veasion.mapper.DictionaryMapper;
import cn.veasion.service.DictionaryService;
import cn.veasion.util.VeaUtil;

@Service("dictionaryService")
@Transactional
public class DictionaryServiceImpl implements DictionaryService{

	@Autowired
	private DictionaryMapper dictionaryMapper;
	
	@Override
	public int insert(Dictionary record) {
		return dictionaryMapper.insert(record);
	}

	@Override
	public int insertSelective(Dictionary record) {
		return dictionaryMapper.insertSelective(record);
	}

	@Override
	public Dictionary selectByPrimaryKey(Integer id) {
		return dictionaryMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Dictionary record) {
		return dictionaryMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Dictionary record) {
		return dictionaryMapper.updateByPrimaryKey(record);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return dictionaryMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Dictionary randomByType(Integer type) {
		Dictionary d=new Dictionary();
		d.setType(type);
		PageModel<Dictionary> pageModel=new PageModel<>();
		pageModel.setObj(d);
		int count=dictionaryMapper.count(pageModel);
		if(count > 0){
			List<Dictionary> result=dictionaryMapper.select(new PageModel<Dictionary>(d, VeaUtil.random(1, count), 1));
			return result != null && !result.isEmpty() ? result.get(0) : null;
		}else{
			return null;
		}
	}
	
	@Override
	public List<Dictionary> selectByType(Integer type) {
		Dictionary d=new Dictionary();
		d.setType(type);
		return dictionaryMapper.select(new PageModel<Dictionary>(d, 1, 50));
	}
	
	@Override
	public List<Dictionary> select(PageModel<Dictionary> pageModel) {
		pageModel.setCount(dictionaryMapper.count(pageModel));
		List<Dictionary> result=dictionaryMapper.select(pageModel);
		pageModel.setResult(result);
		return result;
	}
	
}
