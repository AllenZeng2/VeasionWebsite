package cn.veasion.mapper;

import java.util.List;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.VeasionMusic;

public interface VeasionMusicMapper {

    int insert(VeasionMusic record);

    int insertSelective(VeasionMusic record);

    VeasionMusic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VeasionMusic record);

    int updateByPrimaryKey(VeasionMusic record);
    
    int deleteByPrimaryKey(Integer id);
    
    void click(Integer id);
    
    int count(PageModel<VeasionMusic> pageModel);
    
    List<VeasionMusic> select(PageModel<VeasionMusic> pageModel);
    
}