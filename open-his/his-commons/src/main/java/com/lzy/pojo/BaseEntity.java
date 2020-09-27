package com.lzy.pojo;

import java.io.Serializable;

/**
 * @program: open-his
 * @description: 实体类，实现序列化接口，这样每个实体继承这个类就行不用实现序列化了
 * @author: lzy
 * @create: 2020-09-25 19:27
 **/
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
}
