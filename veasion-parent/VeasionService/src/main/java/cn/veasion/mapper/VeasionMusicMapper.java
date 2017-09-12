package cn.veasion.mapper;

import cn.veasion.entity.VeasionMusic;

public interface VeasionMusicMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VeasionMusic record);

    int insertSelective(VeasionMusic record);

    VeasionMusic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VeasionMusic record);

    int updateByPrimaryKey(VeasionMusic record);
}