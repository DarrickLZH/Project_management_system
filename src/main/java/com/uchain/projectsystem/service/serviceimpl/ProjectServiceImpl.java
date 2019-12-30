package com.uchain.projectsystem.service.serviceimpl;

import com.uchain.projectsystem.VO.ResultVO;
import com.uchain.projectsystem.dao.MemberInfoMapper;
import com.uchain.projectsystem.dao.ProjectInfoMapper;
import com.uchain.projectsystem.dao.TaskInfoMapper;
import com.uchain.projectsystem.entity.MemberInfo;
import com.uchain.projectsystem.entity.ProjectInfo;
import com.uchain.projectsystem.enums.ResultEnum;
import com.uchain.projectsystem.service.ProjectService;
import com.uchain.projectsystem.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

/**
 * @Author: LZH
 * @Date: 2019/11/4 下午7:34
 * @Description:
 */
@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectInfoMapper projectInfoMapper;

    @Autowired
    private TaskInfoMapper taskInfoMapper;

    @Autowired
    private MemberInfoMapper memberInfoMapper;

    @Value("${file.path}")
    private String filePath;

    @Override
    @Transactional
    public Boolean addProject(ProjectInfo projectInfo) {
        ProjectInfo projectInfo1 = projectInfoMapper.selectByProjectName(projectInfo.getName());
        if(projectInfo1 != null){
            return false;
        }
        return (projectInfoMapper.insert(projectInfo) == 1);
    }

    @Override
    public Boolean updateProject(ProjectInfo projectInfo) {
        return (projectInfoMapper.updateByPrimaryKey(projectInfo) == 1);
    }

    @Override
    @Transactional
    public Boolean deleteOne(Integer id) {
        ProjectInfo projectInfo = projectInfoMapper.selectByPrimaryKey(id);
        //删除该项目的周报
        String path = filePath + "/" +projectInfo.getName() + "Report";
        File fileDir = new File(path);
        log.info(path);
        String name = fileDir.getName();
        File[] fileLists = fileDir.listFiles();
        for(int i=0; i< fileLists.length; i++){
            fileLists[i].delete();
            log.info("正在删除第" + i + "个周报");
        }
        fileDir.delete();
        log.info("文件夹删除成功!");
        //删除该项目的所有阶段性任务
        taskInfoMapper.deleteAllByPid(id);
        //删除该项目的所有成员信息
        memberInfoMapper.deleteOneAll(id);
        File evidenceDir = new File(filePath + "/evidence");
        //删除该项目的支付凭证与合同证明
        File[] evidenceLists = evidenceDir.listFiles();
        for(int i=0; i<evidenceLists.length; i++){
            if(evidenceLists[i].getName().equals(id + ".jpg") || evidenceLists[i].getName().equals(id + "Contract.jpg")){
                evidenceLists[i].delete();
                break;
            }
        }
        return (projectInfoMapper.deleteByPrimaryKey(id) == 1);
    }

    @Override
    public ProjectInfo getOne(Integer id) {
        return projectInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public ProjectInfo getOneByName(String name) {
        return projectInfoMapper.selectByProjectName(name);
    }

    @Override
    public List<ProjectInfo> getAllByType(Integer type) {
        return projectInfoMapper.selectAllByType(type);
    }

    @Override
    public ResultVO createProject(ProjectInfo projectInfo) {
        if(addProject(projectInfo)){
            File file = new File(filePath + "/" +projectInfo.getName() + "Report");
            if(!file.exists()){
                file.mkdir();
            }
            ProjectInfo tempProjectInfo = projectInfoMapper.selectByProjectName(projectInfo.getName());
            MemberInfo memberInfo = new MemberInfo();
            memberInfo.setPid(tempProjectInfo.getId());
            memberInfo.setMemberName(projectInfo.getManager());
            memberInfo.setMemberTask("项目负责人");
            return ResultVOUtil.success(tempProjectInfo);
        }else{
            return ResultVOUtil.error(ResultEnum.PROJECT_ALREADY_EXIST);
        }
    }
}
