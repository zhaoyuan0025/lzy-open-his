package com.lzy.config;

/**
 * @program: open-his
 * @description: 支付相关的常量类
 * @author: lzy
 * @create: 2021-04-09 11:10
 **/
public class AliPayConfig {

    //应用的ID，申请时的APPID
    public static String app_id = "你的APPID";
    //SHA256withRsa对应支付宝公钥
    public static String alipay_public_key = "注意使用自己的支付宝公钥";
    //签名方式
    public static String sign_type = "RSA2";
    //字码编码格式
    public static String charset = "utf-8";

}
