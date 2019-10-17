package com.uchain.projectsystem.service;

import com.uchain.projectsystem.DTO.UserDTO;
import com.uchain.projectsystem.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("林钟辉");
        userDTO.setRole(1);
        userService.addUser(userDTO);
        System.out.println(userDTO);
    }
}
