package cn.veasion.mapper;

import java.util.List;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.DesktopCloumn;

public interface DesktopCloumnMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(DesktopCloumn record);

    int insertSelective(DesktopCloumn record);

    DesktopCloumn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DesktopCloumn record);

    int updateByPrimaryKey(DesktopCloumn record);
    
    List<DesktopCloumn> selectByStyleId(Integer styleId);
    
    int count(PageModel<DesktopCloumn> pageModel);
    
    List<DesktopCloumn> select(PageModel<DesktopCloumn> pageModel);
    
}