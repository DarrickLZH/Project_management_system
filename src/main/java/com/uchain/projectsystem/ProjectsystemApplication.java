package com.uchain.projectsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.uchain.projectsystem.dao")
//@EnableScheduling
public class ProjectsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectsystemApplication.class, args);
    }

}
