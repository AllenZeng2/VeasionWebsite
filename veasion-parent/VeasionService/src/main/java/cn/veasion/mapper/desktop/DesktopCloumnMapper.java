package cn.veasion.mapper.desktop;

import java.util.List;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.desktop.DesktopCloumn;

public interface DesktopCloumnMapper {
	
    int insert(DesktopCloumn record);

    int insertSelective(DesktopCloumn record);

    DesktopCloumn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DesktopCloumn record);

    int updateByPrimaryKey(DesktopCloumn record);
    
    int deleteByPrimaryKey(Integer id);
    
    int deleteStyleCloumn(Integer cloumnId);
    
    List<DesktopCloumn> selectByStyleId(Integer styleId);
    
    int count(PageModel<DesktopCloumn> pageModel);
    
    List<DesktopCloumn> select(PageModel<DesktopCloumn> pageModel);
    
}