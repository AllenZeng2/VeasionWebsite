package cn.veasion.service;

import java.util.List;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.DesktopStyle;

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
    
    int deleteByPrimaryKey(Integer id);
    
    DesktopStyle selectForInUse();
    
    List<DesktopStyle> select(PageModel<DesktopStyle> pageModel);
    
}
