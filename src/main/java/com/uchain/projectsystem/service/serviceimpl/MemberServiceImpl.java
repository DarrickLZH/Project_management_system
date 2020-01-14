package com.uchain.projectsystem.service.serviceimpl;

import com.uchain.projectsystem.VO.ResultVO;
import com.uchain.projectsystem.dao.MemberInfoMapper;
import com.uchain.projectsystem.dao.ProjectInfoMapper;
import com.uchain.projectsystem.dto.ProjectDTO;
import com.uchain.projectsystem.entity.MemberInfo;
import com.uchain.projectsystem.entity.ProjectInfo;
import com.uchain.projectsystem.form.projectform.MemberForm;
import com.uchain.projectsystem.service.MemberService;
import com.uchain.projectsystem.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.management.MemoryNotificationInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LZH
 * @Date: 2019/10/21 下午8:33
 * @Description:
 */
@Service
@Slf4j
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberInfoMapper memberInfoMapper;

    @Autowired
    private ProjectInfoMapper projectInfoMapper;

    @Override
    public Boolean delete(Integer id) {
        return (memberInfoMapper.deleteByPrimaryKey(id) == 1);
    }

    @Override
    public Boolean update(List<MemberInfo> memberInfoList) {
        int flag = 0;
        for(MemberInfo memberInfo : memberInfoList){
            memberInfoMapper.updateMemberList(memberInfo);
            flag++;
        }
        return (flag == memberInfoList.size());
    }

    @Override
    public ResultVO getAll(Integer pid) {
        List<MemberInfo> list = memberInfoMapper.selectAll(pid);
        return ResultVOUtil.success(list);
    }

    @Override
    public Boolean insertList(List<MemberForm> memberFormList) {
        return (memberInfoMapper.insertList(memberFormList) != 0);
    }

    @Override
    public Boolean deleteOneProject(Integer pid) {
        return (memberInfoMapper.deleteOneAll(pid) != 0);
    }

    @Override
    @Transactional
    public List<ProjectDTO> getPidByUsername(String userName) {
        List<Integer> pidList = memberInfoMapper.getPidByUsername(userName);
        log.info(pidList.toString());
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        ProjectInfo projectInfo = null;
        if(pidList == null) {
            return null;
        }else{
            for (Integer pid: pidList) {
                ProjectDTO projectDTO = new ProjectDTO();
                projectInfo = projectInfoMapper.selectByPrimaryKey(pid);
                projectDTO.setProjectName(projectInfo.getName());
                projectDTO.setPid(pid);
                projectDTOList.add(projectDTO);
            }
        }
        return projectDTOList;
    }

    @Override
    public MemberInfo getOne(Integer id) {
        return memberInfoMapper.selectByPrimaryKey(id);
    }

}
