package com.lzy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: open-his
 * @description: 登录的数据传输类
 * @author: lzy
 * @create: 2020-09-25 19:48
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginBodyDto implements Serializable {

    //  用户名
    private String username;
    //  密码
    private String password;
    // 验证码
    private String code;

}
