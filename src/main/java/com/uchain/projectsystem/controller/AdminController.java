package com.uchain.projectsystem.controller;

import com.uchain.projectsystem.dto.EquipmentDTO;
import com.uchain.projectsystem.dto.UserDTO;
import com.uchain.projectsystem.accessctro.RoleContro;
import com.uchain.projectsystem.entity.EquipmentInfo;
import com.uchain.projectsystem.enums.ResultEnum;
import com.uchain.projectsystem.enums.RoleEnum;
import com.uchain.projectsystem.form.userform.UserUpdateRoleForm;
import com.uchain.projectsystem.service.*;
import com.uchain.projectsystem.util.RedisUtil;
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

/**
 * @author: LZH
 * @date 2019/9/5 下午5:06
 * @description:
 */
@RequestMapping("/admin")
@RestController
@Api(tags = "管理员接口")
@CrossOrigin
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private EquipmentService equipmentService;

    @Autowired
    private EvidenceService evidenceService;

    @Autowired
    private ProjectReportService projectReportService;

    @Autowired
    private SelfReportService selfReportService;

    @PostMapping("/addUser")
    @ApiOperation("添加用户")
    @RoleContro(role = RoleEnum.ADMIN)
    public Object addUser(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultVOUtil.error(ResultEnum.USERNAME_NOT_EXIST);
        }
        return userService.addUser(userDTO);
    }

    @PostMapping("/delete")
    @ApiOperation("删除用户")
    @RoleContro(role = RoleEnum.ADMIN)
    public Object delete(Integer id) {
        if (userService.delete(id)) {
            return ResultVOUtil.success("删除成功");
        }
        return ResultVOUtil.error(ResultEnum.SQL_ERROR);
    }

    @PostMapping("/updateRole")
    @ApiOperation("更新用户权限")
    @RoleContro(role = RoleEnum.ADMIN)
    public Object updateRole(@Valid UserUpdateRoleForm userUpdateRoleForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultVOUtil.error(0, bindingResult.getFieldError().getDefaultMessage());
        }
        return userService.updateUserRole(userUpdateRoleForm);
    }

    @PostMapping("/resetPw")
    @ApiOperation("管理员重置用户密码")
    @RoleContro(role = RoleEnum.ADMIN)
    public Object resetPw(String username) {
        return userService.resetPw(username);
    }

    @PostMapping("resetNotice")
    @ApiOperation("更新公告")
    @RoleContro(role = RoleEnum.ADMIN)
    public Object addNotice(String notice) {
        String s = "notice";
        redisUtil.delete(s);
        redisUtil.set(s, notice);
        String name = (String) redisUtil.get(s);
        System.out.println(name + ".......................");
        return ResultVOUtil.success();
    }

    @GetMapping("/getAll")
    @ApiOperation("获取所有用户信息")
    @RoleContro(role = RoleEnum.ADMIN)
    public Object getAll() {
        return userService.getAll();
    }

    @GetMapping("/getByPage")
    @ApiOperation("根据页数查询数据")
    @RoleContro(role = RoleEnum.ADMIN)
    public Object getByPage(Integer pageNum) {
        return ResultVOUtil.success(userService.findByPage(pageNum, 2));
    }

    @PostMapping("/addEquipment")
    @ApiOperation("添加一个设备")
    @RoleContro(role = RoleEnum.ADMIN)
    public Object addEquipment(@Valid @RequestBody EquipmentDTO equipmentDTO, BindingResult bindingResult) {
        EquipmentInfo equipmentInfoVe = equipmentService.getOneByEName(equipmentDTO.getEName());
        if (equipmentInfoVe != null) {
            return ResultVOUtil.error(ResultEnum.EQUIPMENT_EXIST);
        }
        EquipmentInfo equipmentInfoIn = new EquipmentInfo();
        BeanUtils.copyProperties(equipmentDTO, equipmentInfoIn);
        if (equipmentService.insert(equipmentInfoIn)) {
            return ResultVOUtil.success(equipmentDTO);
        } else {
            return ResultVOUtil.error(ResultEnum.SQL_ERROR);
        }
    }

    @PostMapping("/updateEquipment")
    @ApiOperation("修改一个设备信息")
    @RoleContro(role = RoleEnum.ADMIN)
    public Object updateEquipment(@RequestBody EquipmentInfo equipmentInfo) {
        if (equipmentService.update(equipmentInfo)) {
            return ResultVOUtil.success(equipmentInfo);
        } else {
            return ResultVOUtil.error(ResultEnum.SQL_ERROR);
        }
    }

    @PostMapping("/deleteEquipment")
    @ApiOperation("删除一个设备信息")
    @RoleContro(role = RoleEnum.ADMIN)
    public Object deleteEquipment(Integer id) {
        if (equipmentService.delete(id)) {
            return ResultVOUtil.success("删除成功");
        } else {
            return ResultVOUtil.error(ResultEnum.SQL_ERROR);
        }
    }

    @PostMapping("/uploadEvidence")
    @ApiOperation("获取前端传来的支付凭证图片")
    @RoleContro(role = RoleEnum.ADMIN)
    public Object uploadEvidence(Integer pid, MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        return evidenceService.getPicture(pid, file, request, response);
    }

    @PostMapping("/uploadContract")
    @ApiOperation("获取前端传来的合同证明图片")
    @RoleContro(role = RoleEnum.ADMIN)
    public Object uploadContract(Integer pid, MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        return evidenceService.getContract(pid, file, request, response);
    }

    @PostMapping("/downloadAllReport")
    @ApiOperation("打包下载该项目所有周报")
    @RoleContro(role = RoleEnum.ADMIN)
    public void downloadAllReport(Integer pid, HttpServletRequest request, HttpServletResponse response){
        projectReportService.downloadAllReport(pid, response, request);
    }

    @PostMapping("/getAllReport")
    @ApiOperation("查询该项目所有周报")
    @RoleContro(role = RoleEnum.ADMIN)
    public Object getAllReport(Integer pid) {
        return projectReportService.getAllByType(pid);
    }

    @GetMapping("/getAllSelfReport")
    @ApiOperation("管理员查看所有人周报列表")
    @RoleContro(role = RoleEnum.ADMIN)
    public Object getAllSelfReport(){
        return selfReportService.getAll();
    }

    @PostMapping("/downloadSelfReport")
    @ApiOperation("管理员下载指定的周报")
    @RoleContro(role = RoleEnum.ADMIN)
    public Object downloadSelfReport(String fileName, HttpServletRequest request, HttpServletResponse response) {
        return selfReportService.downloadReport(fileName, request, response);
    }

    @PostMapping("/downloadAllSelfReport")
    @ApiOperation("管理员打包下载所有个人周报")
    @RoleContro(role = RoleEnum.ADMIN)
    public void downloadAllSelfReport(HttpServletRequest request, HttpServletResponse response) {
        selfReportService.downloadAllReport(request, response);
    }
}
