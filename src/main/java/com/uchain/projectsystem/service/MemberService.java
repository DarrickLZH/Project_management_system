package com.uchain.projectsystem.service;

import com.uchain.projectsystem.VO.ResultVO;
import com.uchain.projectsystem.dto.ProjectDTO;
import com.uchain.projectsystem.entity.MemberInfo;
import com.uchain.projectsystem.form.projectform.MemberForm;

import java.util.List;

/**
 * @Author: LZH
 * @Date: 2019/10/21 下午8:22
 * @Description:
 */
public interface MemberService {

    /**
     * 删除一个项目中的成员
     * @param id
     * @return
     */
    Boolean delete(Integer id);

    /**
     * 更新一个项目中成员的任务
     * @param memberInfo
     * @return
     */
    Boolean update(List<MemberInfo> memberInfoList);

    /**
     * 批量加入
     * @param memberFormList
     * @return
     */
    Boolean insertList(List<MemberForm> memberFormList);

    /**
     * 通过项目id删除所有该项目成员
     * @param pid
     * @return
     */
    Boolean deleteOneProject(Integer pid);

    List<ProjectDTO> getPidByUsername(String userName);

    MemberInfo getOne(Integer id);

    /**
     * 获取某个项目的所有成员及任务
     * @return
     */
    ResultVO getAll(Integer pid);

}
