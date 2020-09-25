package com.lzy.utils;

import com.lzy.enums.ResultEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: open-his
 * @description: 结果集的返回
 * @author: lzy
 * @create: 2020-09-25 19:33
 **/
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -6605778136187803583L;

    private Integer code;
    private String msg;
    private T data;

    /**
     * 默认是成功
     */
    public Result(){
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = ResultEnum.SUCCESS.getMsg();
    }

    public Result(String msg){
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = msg;
    }

    public Result(T data){
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = ResultEnum.SUCCESS.getMsg();
        this.data = data;
    }

    public Result(String msg,T data){
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = msg;
        this.data = data;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

}
