package com.uchain.projectsystem.controller;

import com.uchain.projectsystem.enums.ResultEnum;
import com.uchain.projectsystem.form.LoginForm;
import com.uchain.projectsystem.service.UserService;
import com.uchain.projectsystem.util.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author: LZH
 * @date 2019/9/6 上午10:37
 * @description:
 */
@RestController
@RequestMapping("/anon")
@Api(tags = "用户认证接口")
@Slf4j
@CrossOrigin
public class AnonController {

    @Autowired
    private UserService userService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public Object login(@Valid LoginForm loginForm, HttpServletResponse response, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            log.info("用户名或密码不能为空");
            return ResultVOUtil.error(ResultEnum.LOGIN_INFO_IS_NULL);
        }
        return userService.login(loginForm, response);
    }
}
