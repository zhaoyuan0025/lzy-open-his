package com.lzy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: open-his
 * @description: 就诊系统模块的启动类
 * @author: lzy
 * @create: 2020-09-20 16:13
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.lzy.mapper"})
//@EnableDubbo
public class DoctorApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoctorApplication.class,args);
        System.out.println("就诊模块的系统模块的环境启动成功！");
    }
}
