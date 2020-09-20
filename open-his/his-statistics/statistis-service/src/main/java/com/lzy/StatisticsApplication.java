package com.lzy;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: open-his
 * @description: 就诊模块系统的启动类
 * @author: lzy
 * @create: 2020-09-20 16:45
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.lzy.mapper"})
@EnableDubbo
public class StatisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(StatisticsApplication.class,args);
        System.out.println("就诊模块的环境启动成功！");
    }
}
