package cn.veasion.mapper;

import cn.veasion.entity.VeasionUrl;

public interface VeasionUrlMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VeasionUrl record);

    int insertSelective(VeasionUrl record);

    VeasionUrl selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VeasionUrl record);

    int updateByPrimaryKey(VeasionUrl record);
}