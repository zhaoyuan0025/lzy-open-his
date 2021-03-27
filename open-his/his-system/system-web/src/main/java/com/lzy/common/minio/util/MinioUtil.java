package com.lzy.common.minio.util;

import com.lzy.exception.MedicalException;
import com.lzy.utils.MiuKit;
import io.minio.*;
import io.minio.http.Method;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: open-his
 * @description: 文件上传的工具类
 * @author: lzy
 * @create: 2021-03-05 10:15
 **/
@Component
@Slf4j
public class MinioUtil {

    @Autowired
    private MinioClient minioClient;

    /**
     * 创建bucket
     *
     * @param bucketName bucket名称
     */
    @SneakyThrows
    public void createBucket(String bucketName) {
        if(!minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build())){
            //不存在
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            minioClient.setBucketPolicy(SetBucketPolicyArgs.builder().config("*.*").build());
        }
    }

    /**
     * 上传文件
     * @param uploadDTO
     * @return
     */
    public String upload(UploadDTO uploadDTO){
        try {
            if (MiuKit.isEmpty(uploadDTO)){ throw new MedicalException("请输入正确参数!");}
            String bucktName = uploadDTO.getBuckName();
            MultipartFile file = uploadDTO.getFile();
            if (MiuKit.isEmpty(file)){ throw new MedicalException("请选择文件!");}
            String contentType = file.getContentType();
            InputStream inputStream = file.getInputStream();

            //上传的文件的大小
            long size = file.getSize();
            if (size == 0){
                throw new MedicalException("上传的文件没有内容!");
            }
            String fileSize = FileSizeUtils.FormetFileSize(size);
            log.info("文件的大小为："+fileSize);

            //判断桶是否存在
            createBucket(uploadDTO.getBuckName());
            String filename = file.getOriginalFilename();
            log.info("1.filename:{}",filename);
            assert filename !=null;
            String newFileName = "";
            if(filename.contains(".")){
                String[] split = filename.split("\\.");
                String prefix= split[0];
                String suffix = split[1];
                newFileName = prefix+"_"+System.nanoTime()+"."+suffix;
            }else {
                newFileName = System.nanoTime() +"_"+filename;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            // 文件存储的目录结构
            //文件名要自定义,防止重名
            String objectName = sdf.format(new Date()) + "/" + newFileName;
            log.info("2.objectName:{}",objectName);

//            PutObjectOptions options = new PutObjectOptions(inputStream.available(), -1);
//            options.setContentType(contentType);
            ObjectWriteResponse response = minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucktName)
                    .object(objectName)
                    .stream(inputStream, file.getSize(), -1).contentType(contentType).build());
            log.info(">>>>>>response:{}>>>>>",response);
//            minioClient.putObject(bucktName, objectName,inputStream,options );
            inputStream.close();
            log.info("文件上传成功!");

            //返回url
            String picUrl = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder()
                    .bucket(bucktName).object(objectName).method(Method.GET).build());
//            //转为utf-8
            String decodeUrl = URLDecoder.decode(picUrl, "UTF-8");
//            String proxyUrl = StrUtil.replace(decodeUrl, minioProp.getApiEndpoint(),  minioProp.getProxyEndpoint(), true);
//            log.info("3.pic-> decodeUrl:{}, proxyUrl:{}",decodeUrl,proxyUrl);
            return decodeUrl;
        } catch (Exception e) {
            log.error("上传失败: {}！", e.getMessage());
            throw new MedicalException("文件上传失败");
        }
    }

}