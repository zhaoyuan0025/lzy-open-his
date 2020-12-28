package com.lzy.exception;

import com.lzy.enums.ResultEnum;
import lombok.Data;

/**
 * @program: open-his
 * @description: 自定义的异常处理
 * @author: lzy
 * @create: 2020-12-29 00:15
 **/
@Data
public class MedicalException extends RuntimeException{

    private static final long serialVersionUID = 2450214686001409867L;

    private Integer errorCode = ResultEnum.ERROR.getCode();

    public MedicalException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.errorCode = resultEnum.getCode();
    }

    public MedicalException(ResultEnum resultEnum, Throwable throwable) {
        super(resultEnum.getMsg(), throwable);
        this.errorCode = resultEnum.getCode();
    }

    public MedicalException(Integer errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public MedicalException(String msg) {
        super(msg);
    }

    public MedicalException(Throwable throwable) {
        super(throwable);
    }

    public MedicalException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
