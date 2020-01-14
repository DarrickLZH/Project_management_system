package com.uchain.projectsystem.service.serviceimpl;

import com.uchain.projectsystem.VO.ResultVO;
import com.uchain.projectsystem.dao.TaskInfoMapper;
import com.uchain.projectsystem.entity.TaskInfo;
import com.uchain.projectsystem.form.projectform.TaskForm;
import com.uchain.projectsystem.service.TaskService;
import com.uchain.projectsystem.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: LZH
 * @Date: 2019/11/2 下午4:12
 * @Description:
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskInfoMapper taskInfoMapper;

    @Override
    public Boolean delete(Integer id) {
        return (taskInfoMapper.deleteByPrimaryKey(id) == 1);
    }

    @Override
    public Boolean update(List<TaskInfo> taskInfoList) {
        int flag = 0;
        for(TaskInfo taskInfo : taskInfoList){
            taskInfoMapper.updateByPrimaryKey(taskInfo);
            flag++;
        }
        return (flag == taskInfoList.size());
    }

    @Override
    @Transactional
    public Boolean insertList(List<TaskForm> taskFormList) {
        return (taskInfoMapper.insertList(taskFormList) != 0);
    }

    @Override
    public Boolean deleteAllByPid(Integer pid) {
        return (taskInfoMapper.deleteAllByPid(pid) != 0);
    }

    @Override
    public TaskInfo getOne(Integer id) {
        return taskInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public ResultVO getAllByType(Integer type) {
        return ResultVOUtil.success(taskInfoMapper.selectAllByType(type));
    }

    @Override
    public ResultVO getAll(Integer pid) {
        return ResultVOUtil.success(taskInfoMapper.selectAll(pid));
    }
}
