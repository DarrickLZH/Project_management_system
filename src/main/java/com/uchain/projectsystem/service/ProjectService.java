package com.uchain.projectsystem.service;

import com.uchain.projectsystem.VO.ResultVO;
import com.uchain.projectsystem.entity.ProjectInfo;

import java.util.List;

/**
 * @Author: LZH
 * @Date: 2019/11/4 下午7:17
 * @Description:
 */
public interface ProjectService {

    /**
     * 新增项目
     * @param projectInfo
     * @return
     */
    Boolean addProject(ProjectInfo projectInfo);

    /**
     * 更新项目信息
     * @param projectInfo
     * @return
     */
    Boolean updateProject(ProjectInfo projectInfo);

    /**
     * 删除一个项目
     * @param id
     * @return
     */
    Boolean deleteOne(Integer id);

    /**
     * 通过id获取某个项目所有信息
     * @param id
     * @return
     */
    ProjectInfo getOne(Integer id);

    /**
     * 通过项目名称查询项目
     * @param name
     * @return
     */
    ProjectInfo getOneByName(String name);

    /**
     * 获取所有项目
     * @return
     */
    List<ProjectInfo> getAllByType(Integer type);

    ResultVO createProject(ProjectInfo projectInfo);

}
