package cn.veasion.mapper;

import java.util.List;
import java.util.Map;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.DesktopStyle;

public interface DesktopStyleMapper {
	
    int insert(DesktopStyle record);

    int insertSelective(DesktopStyle record);

    int insertStyleCloumn(Map<String, Object> map);
    
    DesktopStyle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DesktopStyle record);

    int updateByPrimaryKey(DesktopStyle record);
    
    Integer styleSwitchStatus(Integer id);
    
    int deleteByPrimaryKey(Integer id);
    
    int deleteStyleCloumn(Map<String, Object> map);
    
    List<Integer> selectDesktopCloumnIds(Integer styleId);
    
    int count(PageModel<DesktopStyle> pageModel);
    
    List<DesktopStyle> select(PageModel<DesktopStyle> pageModel);
    
}