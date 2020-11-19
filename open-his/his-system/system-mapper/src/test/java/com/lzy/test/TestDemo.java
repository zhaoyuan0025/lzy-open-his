package com.lzy.test;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: open-his
 * @description:
 * @author: lzy
 * @create: 2020-11-19 14:08
 **/
public class TestDemo {

    public static void main(String[] args) {
        try {
            InputStream resource = Resources.getResourceAsStream("");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = builder.build(resource);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
