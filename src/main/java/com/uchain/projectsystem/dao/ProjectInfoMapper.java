package com.uchain.projectsystem.dao;

import com.uchain.projectsystem.entity.ProjectInfo;
import java.util.List;

public interface ProjectInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectInfo record);

    ProjectInfo selectByPrimaryKey(Integer id);

    ProjectInfo selectByProjectName(String projectName);

    List<ProjectInfo> selectAll();

    int updateByPrimaryKey(ProjectInfo record);

    List<ProjectInfo> selectAllByType(Integer type);
}