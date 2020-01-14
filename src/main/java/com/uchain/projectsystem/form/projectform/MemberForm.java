package com.uchain.projectsystem.form.projectform;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.aspectj.bridge.IMessage;

import javax.validation.constraints.NotNull;

/**
 * @Author: LZH
 * @Date: 2019/10/26 下午12:58
 * @Description:
 */
@Data
public class MemberForm {
    /**
     * 该成员参与的项目id
     */
    @ApiModelProperty("项目id")
    @NotNull(message = "项目id不能空")
    private Integer pid;

    /**
     * 成员姓名
     */
    @ApiModelProperty("成员姓名")
    @NotNull(message = "成员姓名不能为空")
    private String memberName;

    /**
     * 成员任务
     */
    @ApiModelProperty("成员任务")
    @NotNull(message = "成员任务不能为空")
    private String memberTask;
}
