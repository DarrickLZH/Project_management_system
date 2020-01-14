package com.uchain.projectsystem.dao;

import com.uchain.projectsystem.entity.TaskInfo;
import com.uchain.projectsystem.form.projectform.TaskForm;

import java.util.List;

public interface TaskInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TaskInfo record);

    TaskInfo selectByPrimaryKey(Integer id);

    List<TaskInfo> selectAll(Integer pid);

    List<TaskInfo> selectAllByType(Integer type);

    int updateByPrimaryKey(TaskInfo record);

    int insertList(List<TaskForm> list);

    int deleteAllByPid(Integer pid);
}