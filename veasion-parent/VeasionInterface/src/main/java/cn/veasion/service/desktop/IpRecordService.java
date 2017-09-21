package cn.veasion.service.desktop;

import java.util.List;

import cn.veasion.bean.PageModel;
import cn.veasion.entity.desktop.IpRecord;

/**
 *  Ip Record Service.
 *  
 *  @author zhuowei.luo
 */
public interface IpRecordService {

    int insert(IpRecord record);

    int insertSelective(IpRecord record);

    IpRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IpRecord record);

    int updateByPrimaryKey(IpRecord record);
    
    int deleteByPrimaryKey(Integer id);
    
    int count(IpRecord ip);
    
    List<IpRecord> select(PageModel<IpRecord> pageModel);
    
}
