package com.uchain.projectsystem.enums;

import lombok.Getter;

/**
 * @author hobo
 * @description
 */
@Getter
public enum ResultEnum {
    PARAMETER_ERROR(100,"项目名，上传时间，项目类型，学号为必填项！"),
    PROJECT_EXIST(101,"项目存在"),
    PROJECT_NOT_EXIST(102,"项目不存在"),
    PRO_UPLOAD_ERROR(103,"文件上传出错"),
    PRO_UPLOAD_SUCCESS(104,"上传成功"),
    DELETE_ERROR(105,"文件删除有误！"),
    DELETE_SUCCESS(106,"文件删除有误！"),
    FILE_IS_NOT_EXIST(107,"文件不存在"),
    FILE_EXIST(108,"文件已存在"),
    USERNAME_NOT_EXIST(109,"用户名不能为空"),
    LOGIN_INFO_IS_NULL(110,"用户名密码不能为空"),
    SQL_ERROR(111,"数据库操作失败"),
    PROJECT_ALREADY_EXIST(112,"项目名已存在"),
    AUTHENTICATION_ERROR(401, "用户认证失败,请重新登录"),
    PERMISSION_DENNY(403, "权限不足"),
    NOT_FOUND(404, "url错误,请求路径未找到"),
    SERVER_ERROR(500, "服务器未知错误:%s"),
    USER_NOT_EXIST(1,"用户不存在" ),
    PASSWORD_ERROR(2,"密码错误" ),
    IS_NOT_PERSONAL_OPERATION(4,"非本人操作"),
    ROLE_CANNOT_BE_NULL(5,"权限不能为空"),
    BASIC_INFO_CANNOT_BE_NULL(6,"基本信息不能为空"),
    EQUIPMENT_EXIST(7,"设备已存在");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
