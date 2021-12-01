//package com.lzy.controller.system;
//
//import com.lzy.common.minio.util.MinioUtil;
//import com.lzy.common.minio.util.UploadDTO;
//import com.lzy.utils.Result;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @program: open-his
// * @description: 图片上传
// * @author: lzy
// * @create: 2021-03-10 16:29
// **/
//@RestController
//@RequestMapping("/upload")
//public class UploadController {
//
//    @Autowired
//    private MinioUtil minioUtil;
//
//    /**
//     * 上传图片
//     * @param dto
//     * @return
//     */
//    @PostMapping("/file")
//    public Result uploadFile(UploadDTO dto){
//        dto.setBuckName("user-file");
//        String upload = minioUtil.upload(dto);
//        return new Result("上传成功！",upload);
//    }
//}
