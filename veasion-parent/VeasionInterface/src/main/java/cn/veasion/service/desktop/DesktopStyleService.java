package cn.veasion.service.desktop;

import java.util.List;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.desktop.DesktopStyle;

/**
 *  Desktop Style Service.
 *  
 *  @author zhuowei.luo
 */
public interface DesktopStyleService {
	
    int insert(DesktopStyle record);

    int insertSelective(DesktopStyle record);

    DesktopStyle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DesktopStyle record);

    int updateByPrimaryKey(DesktopStyle record);
    
    Integer styleSwitchStatus(Integer id);
    
    int deleteByPrimaryKey(Integer id);
    
    DesktopStyle selectForInUse();
    
    List<DesktopStyle> select(PageModel<DesktopStyle> pageModel);
    
}
