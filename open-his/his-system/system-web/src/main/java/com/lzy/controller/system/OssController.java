package com.lzy.controller.system;

import com.lzy.common.oss.OssService;
import com.lzy.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: open-his
 * @description: 文件上传 这里使用的是阿里云OSS
 * @author: lzy
 * @create: 2021-12-22 10:54
 **/
@RestController
@RequestMapping("/oss")
public class OssController {

    @Autowired
    private OssService ossService;

    /**
     * 文件上传
     * @param file 文件
     * @param module 模块
     * @return string
     */
    @PostMapping("/upload")
    public Result<String> upload(@RequestParam("file") MultipartFile file,
                                 @RequestParam("module") String module){
        try {
            InputStream inputStream = file.getInputStream();
            //获取文件名
            String originalFilename = file.getOriginalFilename();
            String url = ossService.upload(inputStream,module,originalFilename);
            return new Result<>("上传成功！",url);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }
}
