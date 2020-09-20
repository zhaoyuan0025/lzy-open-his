package com.lzy;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: open-his
 * @description: 系统模块的主启动类
 * @author: lzy
 * @create: 2020-09-20 01:45
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.lzy.mapper"})
@EnableDubbo
public class SystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
        System.out.println("主系统的环境搭建成功");
    }
}
