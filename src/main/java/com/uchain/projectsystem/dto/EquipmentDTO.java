package com.uchain.projectsystem.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Author: LZH
 * @Date: 2019/11/13 下午5:28
 * @Description:
 */
@Data
public class EquipmentDTO {

    @NotNull(message = "设备名不能空")
    @ApiModelProperty("设备名")
    private String eName;

    @NotNull(message = "设备价格不能空")
    @ApiModelProperty("设备价格")
    private String ePrice;

    @NotNull(message = "设备状态不能为空")
    @ApiModelProperty("设备状态")
    private Integer eState;

    @NotNull(message = "采购方不能为空")
    @ApiModelProperty("采购方")
    private String purchaser;

    @NotNull(message = "设备负责人不能为空")
    @ApiModelProperty("设备负责人")
    private String eManager;
}
