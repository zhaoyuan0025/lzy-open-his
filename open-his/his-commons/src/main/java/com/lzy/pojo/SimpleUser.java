package com.lzy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: open-his
 * @description: 用户对象传输类
 * @author: lzy
 * @create: 2020-09-25 19:30
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleUser implements Serializable {
    private Serializable userId;
    private String userName;

}
