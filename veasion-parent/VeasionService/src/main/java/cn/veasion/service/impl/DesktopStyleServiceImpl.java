package cn.veasion.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.veasion.bean.EntityBean;
import cn.veasion.bean.PageModel;
import cn.veasion.entity.DesktopCloumn;
import cn.veasion.entity.DesktopStyle;
import cn.veasion.mapper.DesktopCloumnMapper;
import cn.veasion.mapper.DesktopStyleMapper;
import cn.veasion.service.DesktopStyleService;
import cn.veasion.service.RedisSimpleService;
import cn.veasion.util.VeaUtil;

@Service("desktopStyleService")
@Transactional
public class DesktopStyleServiceImpl implements DesktopStyleService{

	@Autowired
	private DesktopStyleMapper desktopStyleMapper;
	@Autowired
	private DesktopCloumnMapper desktopCloumnMapper;
	@Autowired
	private RedisSimpleService redisSimpleService;
	
	@Override
	public int insert(DesktopStyle record) {
		int count=desktopStyleMapper.insert(record);
		if (count > 0) {
			this.insertStyleCloumn(record);
		}
		return count;
	}
	
	private void insertStyleCloumn(DesktopStyle record){
		if(!VeaUtil.isNullEmpty(record.getDesktopCloumnIds())){
			Map<String, Object> map=new HashMap<>();
			map.put("styleId", record.getId());
			map.put("cloumnIds", record.getDesktopCloumnIds());
			desktopStyleMapper.insertStyleCloumn(map);
		}
	}
	
	@Override
	public int insertSelective(DesktopStyle record) {
		int count=desktopStyleMapper.insertSelective(record);
		if (count > 0) {
			this.insertStyleCloumn(record);
		}
		return count;
	}
	
	@Override
	public DesktopStyle selectByPrimaryKey(Integer id) {
		DesktopStyle style= desktopStyleMapper.selectByPrimaryKey(id);
		if(style!=null){
			this.selectDesktopCloumn(style);
		}
		return style;
	}
	
	private void selectDesktopCloumn(DesktopStyle style){
		if(style.getId() !=null){
			List<DesktopCloumn> cloumns=desktopCloumnMapper.selectByStyleId(style.getId());
			if(!VeaUtil.isNullEmpty(cloumns)){
				style.setDesktopCloumns(cloumns);
				List<Integer> ids=new ArrayList<>();
				for (DesktopCloumn cloumn : cloumns) {
					ids.add(cloumn.getId());
				}
				style.setDesktopCloumnIds(ids);
			}
		}
	}

	@Override
	public int updateByPrimaryKeySelective(DesktopStyle record) {
		this.updateStyleCloumn(record);
		return desktopStyleMapper.updateByPrimaryKeySelective(record);
	}

	private void updateStyleCloumn(DesktopStyle record){
		List<Integer> cloumnIds_old=desktopStyleMapper.selectDesktopCloumnIds(record.getId());
		List<Integer> cloumnIds_new=record.getDesktopCloumnIds();
		if(!VeaUtil.isNullEmpty(cloumnIds_old) && !VeaUtil.isNullEmpty(cloumnIds_new)){
			List<Integer> temp=new ArrayList<>();
			temp.addAll(cloumnIds_old);
			cloumnIds_old.removeAll(cloumnIds_new);
			cloumnIds_new.removeAll(temp);
		}
		if(!VeaUtil.isNullEmpty(cloumnIds_old)){
			Map<String, Object> mapDel=new HashMap<>();
			mapDel.put("styleId", record.getId());
			mapDel.put("cloumnIds", cloumnIds_old);
			desktopStyleMapper.deleteStyleCloumn(mapDel);
		}
		if(!VeaUtil.isNullEmpty(cloumnIds_new)){
			Map<String, Object> mapAdd=new HashMap<>();
			mapAdd.put("styleId", record.getId());
			mapAdd.put("cloumnIds", cloumnIds_new);
			desktopStyleMapper.insertStyleCloumn(mapAdd);
		}
	}
	
	@Override
	public int updateByPrimaryKey(DesktopStyle record) {
		this.updateStyleCloumn(record);
		return desktopStyleMapper.updateByPrimaryKey(record);
	}

	@Override
	public Integer styleSwitchStatus(Integer id) {
		redisSimpleService.delete(DesktopStyle.REDIS_KEY+"InUse");
		return desktopStyleMapper.styleSwitchStatus(id);
	}
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		int count=desktopStyleMapper.deleteByPrimaryKey(id);
		if (count > 0) {
			Map<String, Object> map=new HashMap<>();
			map.put("styleId", id);
			desktopStyleMapper.deleteStyleCloumn(map);
		}
		return count;
	}
	
	@Override
	public DesktopStyle selectForInUse() {
		Serializable obj=redisSimpleService.get(DesktopStyle.REDIS_KEY+"InUse");
		if(obj!=null && obj instanceof DesktopStyle){
			return (DesktopStyle)obj;
		}
		PageModel<DesktopStyle> pageModel=new PageModel<>(1, 1);
		DesktopStyle style=new DesktopStyle();
		style.setStatus(EntityBean.STATUS_USE);
		pageModel.setObj(style);
		List<DesktopStyle> styles=desktopStyleMapper.select(pageModel);
		if(!VeaUtil.isNullEmpty(styles)){
			style=styles.get(0);
			if(style!=null){
				this.selectDesktopCloumn(style);
			}
			redisSimpleService.add(DesktopStyle.REDIS_KEY+"InUse", style, 12, TimeUnit.HOURS);
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
