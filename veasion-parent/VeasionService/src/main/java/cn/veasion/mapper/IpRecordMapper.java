package cn.veasion.mapper;

import cn.veasion.entity.IpRecord;

public interface IpRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IpRecord record);

    int insertSelective(IpRecord record);

    IpRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IpRecord record);

    int updateByPrimaryKey(IpRecord record);
}