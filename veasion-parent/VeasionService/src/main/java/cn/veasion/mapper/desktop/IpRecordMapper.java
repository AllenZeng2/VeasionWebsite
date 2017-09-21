package cn.veasion.mapper.desktop;

import java.util.List;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.desktop.IpRecord;

public interface IpRecordMapper {
	
    int insert(IpRecord record);

    int insertSelective(IpRecord record);

    IpRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IpRecord record);

    int updateByPrimaryKey(IpRecord record);
    
    int deleteByPrimaryKey(Integer id);
    
    int count(PageModel<IpRecord> pageModel);
    
    List<IpRecord> select(PageModel<IpRecord> pageModel);
    
}