package cn.veasion.service;

import java.util.List;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.VeasionMusic;

/**
 * VeasionMusic Service. 
 * 
 * @author zhuowei.luo
 */
public interface VeasionMusicService {

    int insert(VeasionMusic record);

    int insertSelective(VeasionMusic record);

    VeasionMusic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VeasionMusic record);

    int updateByPrimaryKey(VeasionMusic record);
    
    int deleteByPrimaryKey(Integer id);
    
    List<VeasionMusic> random(Integer count);
    
    void click(Integer id);
    
    List<VeasionMusic> select(PageModel<VeasionMusic> pageModel);
	
}
