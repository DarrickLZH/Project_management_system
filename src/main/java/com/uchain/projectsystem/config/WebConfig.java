package com.uchain.projectsystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: LZH
 * @Date: 2019/10/4 下午3:44
 * @Description:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置访问前缀
        registry.addResourceHandler("/getEvidence/**")
                //配置真实路径
                .addResourceLocations("file:/home/lzh/IdeaProjects/ProjectManagementSystem/evidence/");
    }
}
