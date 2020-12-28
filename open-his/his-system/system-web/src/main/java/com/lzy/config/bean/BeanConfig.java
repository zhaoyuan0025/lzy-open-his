package com.lzy.config.bean;

import com.lzy.utils.IdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: open-his
 * @description: bean对象
 * @author: lzy
 * @create: 2020-12-29 01:40
 **/
@Configuration
public class BeanConfig {

    @Bean
    public IdWorker idWorker(){
        return new IdWorker();
    }
}
