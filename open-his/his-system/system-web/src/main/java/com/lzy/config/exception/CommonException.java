package com.lzy.config.exception;

import com.lzy.exception.MedicalException;
import com.lzy.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: open-his
 * @description: 通用的异常处理
 * @author: lzy
 * @create: 2021-03-10 14:07
 **/
@Slf4j
@ControllerAdvice
public class CommonException {

    /**
     * 统一处理 BlogException
     *
     * @param exception
     */
    @ExceptionHandler(MedicalException.class)
    @ResponseBody
    public Result<Object> exceptionHandler(MedicalException exception) {
        log.error("统一异常处理：", exception);
        return new Result<>(exception.getErrorCode(), exception.getMessage());
    }
}
