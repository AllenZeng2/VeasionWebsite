package cn.veasion.service;

import java.util.List;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.VeasionUrl;

/**
 * VeasionUrl Service.
 * 
 * @author zhuowei.luo
 */
public interface VeasionUrlService {

    int insert(VeasionUrl record);

    int insertSelective(VeasionUrl record);

    VeasionUrl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VeasionUrl record);

    int updateByPrimaryKey(VeasionUrl record);
    
    int deleteByPrimaryKey(Integer id);
    
    List<VeasionUrl> selectByType(Integer type);
    
    List<VeasionUrl> select(PageModel<VeasionUrl> pageModel);
}
