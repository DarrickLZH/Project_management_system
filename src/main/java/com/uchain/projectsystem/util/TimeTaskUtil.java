package com.uchain.projectsystem.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: LZH
 * @Date: 2019/11/24 下午2:57
 * @Description:
 */
@Component
@Slf4j
public class TimeTaskUtil {

    @Value("${file.path}")
    private String filePath;

    @Scheduled(cron = "0/5 * * * * *")
    public void deleteReport(){
//        log.info("定时任务开始.");
//        String path = filePath + "/report";
//        File file = new File(path);
//        File[] fileLists = file.listFiles();
//        for(int i=0; i< fileLists.length; i++){
//            fileLists[i].delete();
//            log.info("正在删除第" + i + "个周报");
//        }
//        log.info("已清空周报!");
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
        String time = format.format(now);
        System.out.println("这里是5秒定时任务"+time);
    }
}
