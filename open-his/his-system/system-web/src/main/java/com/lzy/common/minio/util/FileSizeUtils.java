package com.lzy.common.minio.util;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.lzy.exception.MedicalException;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;

/**
 * @program: aicard-platform
 * @description: 获取文件的大小
 * @author: lzy
 * @create: 2021-01-05 14:42
 **/
@Slf4j
public class FileSizeUtils {

    /**
     * 计算文件大小
     *
     * @param fileLength 文件length
     * @return 文件大小
     */
    public static String FormetFileSize(Long fileLength) {
        String fileSizeString = "";
        DecimalFormat df = new DecimalFormat("#.00");
        if (fileLength != null) {
            if (fileLength < 1024) {
                fileSizeString = df.format((double) fileLength) + "B";
            }
            else if (fileLength < 1048576) {
                fileSizeString = df.format((double) fileLength / 1024) + "K";
            }
            else if (fileLength < 1073741824) {
                fileSizeString = df.format((double) fileLength / 1048576) + "M";
            }
            else {
                fileSizeString = df.format((double) fileLength / 1073741824) + "G";
            }
        }
        return fileSizeString;
    }

    /**
     * 计算文件的大小
     * @param fileUrl
     * @return
     */
    public static Long getFileSize(String fileUrl) {

        if(StringUtils.isNotBlank(fileUrl)&&StringUtils.isNotBlank(fileUrl)){
            try {
                Integer size;
                URL url = new URL(fileUrl);
                URLConnection conn = url.openConnection();
                size = conn.getContentLength();
                if (size < 0) {
                    System.out.println("file size is empty.");
                    throw new MedicalException("文件的大小不能为null");
                }
                log.info("文件的大小" + size);

                System.out.println("File size is = " + size + " bytes");
                //关流
                conn.getInputStream().close();
                Long longSize = (long) size;
//                String fileSize = FileSizeUtils.FormetFileSize(longSize);
//                log.info("文件的大小" + fileSize);
//                System.out.println("File size is = " + fileSize + " bytes");
                return longSize;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }
}
