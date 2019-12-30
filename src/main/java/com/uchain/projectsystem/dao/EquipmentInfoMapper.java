package com.uchain.projectsystem.dao;

import com.uchain.projectsystem.entity.EquipmentInfo;
import java.util.List;

public interface EquipmentInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EquipmentInfo record);

    EquipmentInfo selectByPrimaryKey(Integer id);

    List<EquipmentInfo> selectAll();

    EquipmentInfo selectByEName(String eName);

    int updateByPrimaryKey(EquipmentInfo record);
}