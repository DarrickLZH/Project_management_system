package com.uchain.projectsystem.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: LZH
 * @Date: 2019/11/15 下午5:10
 * @Description:
 */
@Slf4j
public class FileUtil {

    public static boolean downloadFile(String filepath, String filename, HttpServletResponse response, HttpServletRequest request) {
        log.info("文件路径为：" + filepath);
        File file = new File(filepath);
        if (file.exists()) {
            log.info("存在该文件,正在下载");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;fileName=" + filename);
            // 设置文件名
            InputStream inStream = null;
            try {
                inStream = new FileInputStream(file);
                // 循环取出流中的数据
                byte[] b = new byte[1024];
                int len;
                while ((len = inStream.read(b)) > 0) {
                    response.getOutputStream().write(b, 0, len);
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            } finally {
                if (inStream != null) {
                    try {
                        inStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return false;
    }


}
