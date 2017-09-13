package cn.veasion.mapper;

import java.util.List;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.VeasionUrl;

public interface VeasionUrlMapper {
	
    int insert(VeasionUrl record);

    int insertSelective(VeasionUrl record);

    VeasionUrl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VeasionUrl record);

    int updateByPrimaryKey(VeasionUrl record);
    
    int deleteByPrimaryKey(Integer id);
    
    int count(PageModel<VeasionUrl> pageModel);
    
    List<VeasionUrl> select(PageModel<VeasionUrl> pageModel);
    
}