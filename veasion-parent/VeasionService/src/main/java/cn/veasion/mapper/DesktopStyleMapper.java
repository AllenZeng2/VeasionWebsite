package cn.veasion.mapper;

import cn.veasion.entity.DesktopStyle;

public interface DesktopStyleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DesktopStyle record);

    int insertSelective(DesktopStyle record);

    DesktopStyle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DesktopStyle record);

    int updateByPrimaryKey(DesktopStyle record);
}