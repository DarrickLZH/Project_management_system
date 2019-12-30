package com.uchain.projectsystem.service;

import com.uchain.projectsystem.VO.ResultVO;
import com.uchain.projectsystem.entity.EquipmentInfo;

/**
 * @Author: LZH
 * @Date: 2019/11/13 下午5:22
 * @Description:
 */
public interface EquipmentService {

    /**
     * 插入一个设备信息
     *
     * @return
     */
    Boolean insert(EquipmentInfo equipmentInfo);

    /**
     * 删除一个设备
     *
     * @param id
     * @return
     */
    Boolean delete(Integer id);

    /**
     * 更新一个设备
     *
     * @param equipmentInfo
     * @return
     */
    Boolean update(EquipmentInfo equipmentInfo);

    /**
     * 获取某个设备详情
     *
     * @param id
     * @return
     */
    EquipmentInfo getOne(Integer id);

    /**
     * 通过设备名称查询设备
     *
     * @param eName
     * @return
     */
    EquipmentInfo getOneByEName(String eName);

    /**
     * 获取所有设备信息
     *
     * @return
     */
    ResultVO getAll();
}
