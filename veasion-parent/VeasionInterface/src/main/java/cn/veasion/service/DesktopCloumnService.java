package cn.veasion.service;

import java.util.List;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.DesktopCloumn;

/**
 *  Desktop Cloumn.
 *  
 *  @author zhuowei.luo
 */
public interface DesktopCloumnService {
	
	int deleteByPrimaryKey(Integer id);

    int insert(DesktopCloumn record);

    int insertSelective(DesktopCloumn record);

    DesktopCloumn selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DesktopCloumn record);

    int updateByPrimaryKey(DesktopCloumn record);
    
    List<DesktopCloumn> select(PageModel<DesktopCloumn> pageModel);
	
}
