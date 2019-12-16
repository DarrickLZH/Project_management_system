package com.uchain.projectsystem.dao;

import com.uchain.projectsystem.dto.UserDTO;
import com.uchain.projectsystem.dto.UserIdDTO;
import com.uchain.projectsystem.entity.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<UserIdDTO> selectAll();

    int update(User user);

    User selectUserByUsername(String username);
}