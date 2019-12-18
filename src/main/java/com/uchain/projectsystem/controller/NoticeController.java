package com.uchain.projectsystem.controller;

import com.uchain.projectsystem.util.RedisUtil;
import com.uchain.projectsystem.util.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: LZH
 * @Date: 2019/10/19 下午2:44
 * @Description:
 */
@RequestMapping("/notice")
@RestController
@Api(tags = "公告接口")
@CrossOrigin
public class NoticeController {

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/getNotice")
    @ApiOperation("获取公告")
    public Object getOneNotice() {
        String s = "notice";
        String notice = (String)redisUtil.get(s);
        return ResultVOUtil.success(notice);
    }

}
