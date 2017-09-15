package cn.veasion.service;

import java.util.List;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.Dictionary;

/**
 *  Dictionary Service.
 *  
 *  @author zhuowei.luo
 */
public interface DictionaryService {

    int insert(Dictionary record);
    
    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
    
    int deleteByPrimaryKey(Integer id);
    
    Dictionary randomByType(Integer type);
    
    List<Dictionary> selectByType(Integer type);
    
    List<Dictionary> select(PageModel<Dictionary> pageModel);
    
}
