package cn.veasion.mapper;

import java.util.List;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.DesktopStyle;

public interface DesktopStyleMapper {
	
    int insert(DesktopStyle record);

    int insertSelective(DesktopStyle record);

    DesktopStyle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DesktopStyle record);

    int updateByPrimaryKey(DesktopStyle record);
    
    int deleteByPrimaryKey(Integer id);
    
    List<Integer> selectDesktopCloumnIds(Integer styleId);
    
    int count(PageModel<DesktopStyle> pageModel);
    
    List<DesktopStyle> select(PageModel<DesktopStyle> pageModel);
    
}