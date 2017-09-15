package cn.veasion.mapper;

import java.util.List;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.Dictionary;

public interface DictionaryMapper {

    int insert(Dictionary record);
    
    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
    
    int deleteByPrimaryKey(Integer id);
    
    int count(PageModel<Dictionary> pageModel);
    
    List<Dictionary> select(PageModel<Dictionary> pageModel);
    
}