package com.lzy.common.oss.impl;

import cn.hutool.core.date.DateTime;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.lzy.common.oss.OssProperties;
import com.lzy.common.oss.OssService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.UUID;

/**
 * @program: open-his
 * @description: oss的实现类
 * @author: lzy
 * @create: 2021-12-22 10:56
 **/
@Service
@Slf4j
public class OssServiceImpl implements OssService {


    @Override
    public String upload(InputStream inputStream, String module, String originalFilename) {

        //获取阿里云的oss的实例
        OSS oss = new OSSClientBuilder().build(OssProperties.ENDPOINT,
                OssProperties.KEY_ID, OssProperties.KEY_SECRET);

        if (!oss.doesBucketExist(OssProperties.BUCKET_NAME)){
            //如果bucket_name 不存在就创建
            oss.createBucket(OssProperties.BUCKET_NAME);
            //设置bucket_name的权限  这里给公共读的权限
            oss.setBucketAcl(OssProperties.BUCKET_NAME, CannedAccessControlList.PublicRead);
        }

        //格式化日期
        String folder  = new DateTime().toString("yyyy-MM-dd");
        log.info("格式化日期>>>>>>>>>>>>>>>>>>>>>>>>>>>:{}"+folder);
        //重命名文件名
        originalFilename = UUID.randomUUID().toString()
                + originalFilename.substring(originalFilename.lastIndexOf("."));

        //文件根路径
        String key = module + "/" + folder + "/" + originalFilename;
        //文件上传至阿里云
        oss.putObject(OssProperties.BUCKET_NAME, key, inputStream);
        // 关闭OSSClient。
        oss.shutdown();
        //返回阿里云文件绝对路径
        String url = "https://" + OssProperties.BUCKET_NAME + "." + OssProperties.ENDPOINT + "/" + key;
        log.info("上传成功！！！！>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>:{}",url);
        return url;
    }
}
