package com.uchain.projectsystem.service;

import com.uchain.projectsystem.VO.ResultVO;
import com.uchain.projectsystem.entity.TaskInfo;
import com.uchain.projectsystem.form.projectform.TaskForm;

import java.util.List;

/**
 * @Author: LZH
 * @Date: 2019/11/2 下午12:13
 * @Description:
 */
public interface TaskService {

    /**
     * 删除一个项目中的一个阶段任务
     * @param id
     * @return
     */
    Boolean delete(Integer id);

    /**
     * 更新一个项目中的阶段任务
     * @param taskInfo
     * @return
     */
    Boolean update(List<TaskInfo> taskInfoList);

    /**
     * 批量加入
     * @param taskFormList
     * @return
     */
    Boolean insertList(List<TaskForm> taskFormList);

    /**
     * 通过项目id删除所有该项目的阶段性任务
     * @param pid
     * @return
     */
    Boolean deleteAllByPid(Integer pid);

    /**
     * 获取单个
     * @param id
     * @return
     */
    TaskInfo getOne(Integer id);

    /**
     * 通过项目类别查询出所有项目任务
     * @param type
     * @return
     */
    ResultVO getAllByType(Integer type);

    /**
     * 获取某个项目的任务
     * @return
     */
    ResultVO getAll(Integer pid);

}
