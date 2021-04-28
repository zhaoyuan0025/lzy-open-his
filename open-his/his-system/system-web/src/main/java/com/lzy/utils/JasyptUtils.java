package com.lzy.utils;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: open-his
 * @description: 对数据源加密
 * @author: lzy
 * @create: 2021-04-20 10:07
 **/
public class JasyptUtils {

    @Autowired
    StringEncryptor encryptor;

    public static void main(String[] args) {

    }
}
