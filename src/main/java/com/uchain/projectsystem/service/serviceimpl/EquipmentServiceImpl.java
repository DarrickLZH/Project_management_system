package com.uchain.projectsystem.service.serviceimpl;

import com.uchain.projectsystem.VO.ResultVO;
import com.uchain.projectsystem.dao.EquipmentInfoMapper;
import com.uchain.projectsystem.entity.EquipmentInfo;
import com.uchain.projectsystem.service.EquipmentService;
import com.uchain.projectsystem.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: LZH
 * @Date: 2019/11/13 下午5:32
 * @Description:
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private EquipmentInfoMapper equipmentInfoMapper;

    @Override
    public Boolean insert(EquipmentInfo equipmentInfo) {
        return (equipmentInfoMapper.insert(equipmentInfo) == 1);
    }

    @Override
    public Boolean delete(Integer id) {
        return (equipmentInfoMapper.deleteByPrimaryKey(id) == 1);
    }

    @Override
    public Boolean update(EquipmentInfo equipmentInfo) {
        return (equipmentInfoMapper.updateByPrimaryKey(equipmentInfo) == 1);
    }

    @Override
    public EquipmentInfo getOne(Integer id) {
        return equipmentInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public EquipmentInfo getOneByEName(String eName) {
        return equipmentInfoMapper.selectByEName(eName);
    }

    @Override
    public ResultVO getAll() {
        return ResultVOUtil.success(equipmentInfoMapper.selectAll());
    }
}
