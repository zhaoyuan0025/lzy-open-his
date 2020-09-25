package com.lzy.constants;

/**
 * @program: open-his
 * @description: http状态码
 * @author: lzy
 * @create: 2020-09-25 19:38
 **/
public interface HttpStatus {
    /**
     * 操作成功
     */
    int SUCCESS = 200;

    /**
     * 参数列表错误（缺少，格式不匹配）
     */
    int BAD_REQUEST = 400;

    /**
     * 未授权
     */
    int UNAUTHORIZED = 401;

    /**
     * 访问受限，授权过期
     */
    int FORBIDDEN = 403;

    /**
     * 资源，服务未找到
     */
    int NOT_FOUND = 404;

    /**
     * 不允许的http方法
     */
    int BAD_METHOD = 405;

    /**
     * 系统内部错误
     */
    int ERROR = 500;


}
