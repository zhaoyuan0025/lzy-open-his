package com.lzy.aspectj.annotation;

import com.lzy.aspectj.enums.BussinessType;
import com.lzy.aspectj.enums.OperatorType;

import java.lang.annotation.*;

/**
 * @ClassName Log
 * @Description 创建Log 日志的注解
 * @Author 刘少
 * @Date 2020/12/13 22:40
 * @Version 1.0
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
      * 功能描述: 模块
    */
    public String title() default "";

    /**
     * 功能
     */
    public BussinessType businessType() default BussinessType.OTHER;

    /**
     * 操作人类别
     */
    public OperatorType operatorType() default OperatorType.MANAGE;

    /**
      * 功能描述: 是否保存请求的参数
    */
    public boolean isSaveRequestData() default true;
}
