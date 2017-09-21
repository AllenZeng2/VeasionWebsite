package cn.veasion.service.desktop;

import java.util.List;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.desktop.DesktopCloumn;

/**
 *  Desktop Cloumn.
 *  
 *  @author zhuowei.luo
 */
public interface DesktopCloumnService {
	
    int insert(DesktopCloumn record);

    int insertSelective(DesktopCloumn record);

    DesktopCloumn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DesktopCloumn record);

    int updateByPrimaryKey(DesktopCloumn record);
    
    int deleteByPrimaryKey(Integer id);
    
    List<DesktopCloumn> selectByStyleId(Integer styleId);
    
    List<DesktopCloumn> select(PageModel<DesktopCloumn> pageModel);
	
}
