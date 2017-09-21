package cn.veasion.service.website;

import java.util.List;

import cn.veasion.entity.website.Test;

public interface TestService {

    int insert(Test record);

    int insertSelective(Test record);

    List<Test> select();

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);
    
    int deleteByPrimaryKey(Integer id);
}
