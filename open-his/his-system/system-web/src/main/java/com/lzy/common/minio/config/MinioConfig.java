//package com.lzy.common.minio.config;
//
//import io.minio.MinioClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @program: open-his
// * @description: minio的配置文件
// * @author: lzy
// * @create: 2021-03-05 10:40
// **/
//@Configuration
////@EnableConfigurationProperties(MinioProp.class)
//public class MinioConfig {
//
//    @Autowired
//    private MinioProp minioProp;
//
//
//    @Bean
//    public MinioClient minioClient() {
//        //高版本获取  Minioclient
//        MinioClient minioClient = MinioClient.builder()
////                .endpoint(HttpUrl.parse())
//                .endpoint(minioProp.getApiEndpoint())
//                .credentials(minioProp.getAccessKey(), minioProp.getSecretKey())
//                .build();
//        return minioClient;
//    }
//
//}
