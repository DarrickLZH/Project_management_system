package com.uchain.projectsystem.dao;

import com.uchain.projectsystem.entity.NoticeInfo;
import java.util.List;

public interface NoticeInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NoticeInfo record);

    NoticeInfo selectByPrimaryKey(Integer id);

    List<NoticeInfo> selectAll();

    int updateByPrimaryKey(NoticeInfo record);
}