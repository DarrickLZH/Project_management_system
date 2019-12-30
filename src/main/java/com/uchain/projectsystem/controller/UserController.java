package com.uchain.projectsystem.controller;

import com.uchain.projectsystem.dao.SelfReportInfoMapper;
import com.uchain.projectsystem.dto.ProjectDTO;
import com.uchain.projectsystem.entity.MemberInfo;
import com.uchain.projectsystem.entity.ProjectInfo;
import com.uchain.projectsystem.entity.TaskInfo;
import com.uchain.projectsystem.enums.ResultEnum;
import com.uchain.projectsystem.form.projectform.*;
import com.uchain.projectsystem.form.userform.UserUpdatePwForm;
import com.uchain.projectsystem.service.*;
import com.uchain.projectsystem.util.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * @Author: LZH
 * @Date: 2019/10/16 下午5:22
 * @Description:
 */
@RestController
@Api(tags = "用户服务接口")
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    private static final String INITIAL_PAIN_STATE = "未支付";

    @Autowired
    private UserService userService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private ProjectReportService projectReportService;

    @Autowired
    private SelfReportService selfReportService;

    @ApiOperation("用户修改密码")
    @PostMapping(name = "用户修改密码", value = "/updatePw")
    public Object updatePw(@RequestBody UserUpdatePwForm userUpdatePwForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return ResultVOUtil.error(0,bindingResult.getFieldError().getDefaultMessage());
        }
        return userService.updateUserPw(userUpdatePwForm);
    }

    @ApiOperation("项目组长创建项目成员列表")
    @PostMapping(value = "/insertMember")
    public Object insertMembers(@Valid @RequestBody List<MemberForm> memberFormList,BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResultVOUtil.error(ResultEnum.BASIC_INFO_CANNOT_BE_NULL);
        }
        if(memberService.insertList(memberFormList)){
            return ResultVOUtil.success(memberFormList);
        }else {
            return ResultVOUtil.error(ResultEnum.SQL_ERROR);
        }
    }

    @ApiOperation("删除所有该项目的成员")
    @PostMapping(value = "/deleteMemberByPid")
    public Object deleteMemberByPid(Integer pid){
        if(memberService.deleteOneProject(pid)){
            return ResultVOUtil.success("该项目成员已删除");
        }else{
            return ResultVOUtil.error(ResultEnum.SQL_ERROR);
        }
    }

    @ApiOperation("查看该项目所有成员信息")
    @PostMapping(value = "getAllMember")
    public Object getAllMember(Integer pid) {
        return ResultVOUtil.success(memberService.getAll(pid));
    }

    @ApiOperation("项目组长删除某个成员")
    @PostMapping(value = "/deleteMember")
    public Object deleteOne(Integer id){
        if(memberService.delete(id)){
            return ResultVOUtil.success("删除成功");
        }else {
            return ResultVOUtil.error(ResultEnum.SQL_ERROR);
        }
    }

    @ApiOperation("项目组长修改成员的任务分配")
    @PostMapping(value = "/updateMember")
    public Object updateOne(@RequestBody List<MemberInfo> memberInfoList){
        if(memberService.update(memberInfoList)){
            return ResultVOUtil.success(memberInfoList);
        }else {
            return ResultVOUtil.error(ResultEnum.SQL_ERROR);
        }
    }

    @ApiOperation("通过成员姓名查询所拥有的所有项目")
    @PostMapping(value = "/getProjectByUsername")
    public Object getProjectByUsername(String userName){
        List<ProjectDTO> projectDTOList = memberService.getPidByUsername(userName);
        return ResultVOUtil.success(projectDTOList);
    }

    @ApiOperation("项目组长创建项目阶段目标")
    @PostMapping(value = "/insertTask")
    public Object insert(@Valid @RequestBody List<TaskForm> taskFormList, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultVOUtil.error(ResultEnum.BASIC_INFO_CANNOT_BE_NULL);
        }
        if(taskService.insertList(taskFormList)){
            return ResultVOUtil.success(taskFormList);
        }else {
            return ResultVOUtil.error(ResultEnum.SQL_ERROR);
        }
    }

    @ApiOperation("删除所有该项目的所有阶段性任务")
    @PostMapping(value = "/deleteTaskByPid")
    public Object deleteTaskByPid(Integer pid) {
        if(taskService.deleteAllByPid(pid)){
            return ResultVOUtil.success("删除该项目所有任务成功");
        }else{
            return ResultVOUtil.error(ResultEnum.SQL_ERROR);
        }
    }

    @ApiOperation("查看该项目所有阶段任务信息")
    @PostMapping(value = "getAllTask")
    public Object getAllTask(Integer pid) {
        return taskService.getAll(pid);
    }

    @ApiOperation("查看指定类别项目的阶段任务信息")
    @PostMapping(value = "getAllTaskByType")
    public Object getAllTaskByType(@RequestParam(value = "type") Integer type) {
        return ResultVOUtil.success(taskService.getAllByType(type));
    }

    @ApiOperation("项目组长删除某个阶段任务")
    @PostMapping(value = "/deleteTask")
    public Object deleteTask(Integer id){
        if(taskService.delete(id)){
            return ResultVOUtil.success(taskService.getOne(id));
        }else {
            return ResultVOUtil.error(ResultEnum.SQL_ERROR);
        }
    }

    @ApiOperation("项目组长修改项目阶段任")
    @PostMapping(value = "/updateTask")
    public Object updateTask(@RequestBody List<TaskInfo> taskInfoList){
        if(taskService.update(taskInfoList)){
            return ResultVOUtil.success(taskInfoList);
        }else {
            return ResultVOUtil.error(ResultEnum.SQL_ERROR);
        }
    }

    @ApiOperation("新建项目")
    @PostMapping(value = "/addProject")
    public Object addProject(@Valid @RequestBody ProjectForm projectForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultVOUtil.error(ResultEnum.BASIC_INFO_CANNOT_BE_NULL);
        }
        ProjectInfo projectInfo = new ProjectInfo();
        BeanUtils.copyProperties(projectForm,projectInfo);
        projectInfo.setIsPaid(INITIAL_PAIN_STATE);
        return projectService.createProject(projectInfo);
    }

    @ApiOperation("删除项目")
    @PostMapping(value = "/deleteProject")
    public Object deleteProject(Integer id){
        if(projectService.deleteOne(id)){
            return ResultVOUtil.success(projectService.getOne(id));
        }else{
            return ResultVOUtil.error(ResultEnum.SQL_ERROR);
        }
    }

    @ApiOperation("更新项目信息")
    @PostMapping(value = "/updateProject")
    public Object updateProject(@RequestBody ProjectInfo projectInfo){
        if(projectService.updateProject(projectInfo)){
            return ResultVOUtil.success(projectInfo);
        }else{
            return ResultVOUtil.error(ResultEnum.SQL_ERROR);
        }
    }

    @ApiOperation("查询所有项目信息")
    @PostMapping(value = "/getAllProject")
    public Object getAllProject(Integer type){
        return ResultVOUtil.success(projectService.getAllByType(type));
    }

    @ApiOperation("获得单个项目总信息")
    @PostMapping(value = "/getOneProject")
    public Object getOneProject(Integer id){
        return ResultVOUtil.success(projectService.getOne(id));
    }

    @ApiOperation("获取单个设备信息")
    @PostMapping(value = "/getOneEquipment")
    public Object getOneEquipment(Integer id) {
        return ResultVOUtil.success(equipmentService.getOne(id));
    }

    @ApiOperation("获得所有设备信息")
    @GetMapping(value = "/getAllEquipment")
    public Object getAllEquipment() {
        return ResultVOUtil.success(equipmentService.getAll());
    }

    @ApiOperation("接受上传的周报")
    @PostMapping(value = "/uploadProjectReport")
    public Object uploadProjectReport(String userName, Integer pid, MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        return projectReportService.getReport(userName, pid, file, request, response);
    }

    @ApiOperation("下载周报")
    @PostMapping(value = "/downloadProjectReport")
    public Object downloadProjectReport(@RequestBody FileForm fileForm, HttpServletRequest request, HttpServletResponse response){
        return projectReportService.downloadReport(fileForm.getPid(), fileForm.getFileName(), response, request);
    }

    @ApiOperation("上传个人周报")
    @PostMapping(value = "/uploadPersonalReport")
    public Object uploadPersonalReport(String userName, MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        return selfReportService.uploadReport(userName, file, request, response);
    }

    @ApiOperation("获取个人上传的所有周报")
    @PostMapping(value = "/getSelfAllReport")
    public Object getSelfAllReport(String userName) {
        return selfReportService.getSelfAll(userName);
    }

    @ApiOperation("删除个人周报")
    @PostMapping(value = "/deleteSelfReport")
    public Object deleteSelfReport(Integer id) {
        return selfReportService.deleteReport(id);
    }

}