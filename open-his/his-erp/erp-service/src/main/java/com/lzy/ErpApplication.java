package com.lzy;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: open-his
 * @description: erp模块的启动类
 * @author: lzy
 * @create: 2020-09-20 02:12
 **/
@SpringBootApplication
@MapperScan(basePackages = {"com.lzy.mapper"})
@EnableDubbo
public class ErpApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErpApplication.class, args);
        System.out.println("erp子系统启动成功！");
    }
}
