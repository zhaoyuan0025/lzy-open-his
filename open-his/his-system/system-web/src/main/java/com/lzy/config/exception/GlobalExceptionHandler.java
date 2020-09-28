package com.lzy.config.exception;


import com.lzy.vo.AjaxResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: open-his
 * @description: 全局的异常处理
 * @author: lzy
 * @create: 2020-09-29 00:58
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 当系统出现MethodArgumentNotValidException这个异常时，会调用下面的方法
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public AjaxResult jsonErrorHandler(MethodArgumentNotValidException e){
        //将异常信息以json的格式返回
        List<Map<String,Object>> list = new ArrayList<>();
        //得到异常信息对象信息，是一个list集合
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        for (ObjectError allError : allErrors) {
            Map<String, Object> map = new HashMap<>();
            map.put("defaultMessage",allError.getDefaultMessage());
            map.put("objectName",allError.getObjectName());
            //强转,拿到具体的某一属性
            FieldError field = (FieldError) allError;
            map.put("field",field.getField());
            //将map对象加入到list中
            list.add(map);
        }
        return AjaxResult.fail("后端校验数据异常，不通过！",list);
    }

}
