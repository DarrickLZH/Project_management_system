package com.uchain.projectsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.uchain.projectsystem.dao")
public class ProjectsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectsystemApplication.class, args);
    }

}
