package com.lzy;

import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * @program: open-his
 * @description: 系统模块的主启动类
 * @author: lzy
 * @create: 2020-09-20 01:45
 **/
@Slf4j
@SpringBootApplication
@MapperScan(basePackages = {"com.lzy.mapper"})
//@EnableDubbo
public class SystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
//        System.out.println("主系统的环境搭建成功");
        System.out.println(""+"\n"
        +"======================================================================="+"\n"
        +"=====================                         ========================="+"\n"
        +"=====================  在编程的道路上渐行渐远     ========================="+"\n"
        +"=====================  环境启动成功             ========================="+"\n"
        +"=====================                         ========================="+"\n"
        +"======================================================================="+"\n"
        );
    }

    /**
     * 处理long类型精度丢失的问题
     * @return
     */
    @Bean("jackson2ObjectMapperBuilderCustomizer")
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer(){
        return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.serializerByType(Long.class, ToStringSerializer.instance)
                .serializerByType(Long.TYPE,ToStringSerializer.instance);
    }

}
