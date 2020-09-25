package com.lzy.enums;

import lombok.Getter;

/**
 * @program: open-his
 * @description: 状态码
 * @author: lzy
 * @create: 2020-09-25 18:33
 **/
@Getter
public enum HttpStatusEnum {

    SUCCESS(20000,"操作成功"),

    BAD_REQUEST(40000,"参数列表错误"),
    UNAUTHORIZED(40001,"用户未授权"),
    FORBIDDEN(40003,"访问受限,授权过期"),
    NOT_FOUND(40004,"资源，服务未找到"),
    BAD_METHOD(40005,"不允许的http方法"),

    ERROR(50000,"系统内部错误")
    ;

    private Integer code;
    private String msg;

    HttpStatusEnum(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
