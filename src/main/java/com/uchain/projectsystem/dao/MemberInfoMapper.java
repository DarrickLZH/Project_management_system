package com.uchain.projectsystem.dao;

import com.uchain.projectsystem.entity.MemberInfo;
import com.uchain.projectsystem.form.projectform.MemberForm;

import java.util.List;

public interface MemberInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberInfo record);

    MemberInfo selectByPrimaryKey(Integer id);

    int updateMemberList(MemberInfo memberInfo);

    List<MemberInfo> selectAll(Integer pid);

    int insertList(List<MemberForm> list);

    int deleteOneAll(Integer pid);

    List<Integer> getPidByUsername(String userName);

}