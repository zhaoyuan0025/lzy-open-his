package com.lzy.controller.system;

import com.lzy.common.minio.util.MinioUtil;
import com.lzy.common.minio.util.UploadDTO;
import com.lzy.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @program: open-his
 * @description: 测试
 * @author: lzy
 * @create: 2021-03-05 17:11
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private MinioUtil minioUtil;

    @GetMapping("/upload")
    public Result<String> upload(MultipartFile file){
        UploadDTO dto = UploadDTO.builder().file(file).buckName("bucket-user").build();
        String upload = minioUtil.upload(dto);
        return new Result<>("上传成功",upload);
    }
}
