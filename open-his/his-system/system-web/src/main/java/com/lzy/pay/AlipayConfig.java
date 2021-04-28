package com.lzy.pay;

/**
 * @program: open-his
 * @description: 支付相关的常量类
 * @author: lzy
 * @create: 2021-04-09 11:10
 **/
public class AlipayConfig {

    /**
     * 应用的ID，申请时的APPID
     */
    public static String app_id = "ENC(Tfj+X5ZjiAqkGelIANU2AxL4iwBcZ319/McTYYSJhOPm5xPGJ9Kq3uVdn1KbHbMcWbVBacB3dkMOhZxAqNVd8g==)";

    /**
     * SHA256withRsa对应支付宝公钥
     */
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlTdAY9IVge+whNkxvemA+aJxspTKJILxcHQZUUVa5GOhnOqpiA1BVrPwOI7SoIOrLBBRPSul7mkQDj2pYEec6G4p+RrgzkldYHFM15l/MvYSS9Y9xf7Pjz0uivetIJqzl7fhqjq7zUvZRgai1OYs6J8EBGOS+OsfOMeT94p6iDCPXLgpBpppDJZlaZLS6GOSeg6o2mdwU/uRnNVE3bHorEXIsd54+phiTQmesw2KZW0y33oakOdVaTKROVw8ZMVaGQNK1lQNc7ZTicLDTGlZ4mXywLLZ7gEkcM09Einr/BSe2b+l4GZUaDVHstWFON52f9kPK23VaVuXHZ9XcHgbbwIDAQAB";

    /**
     * 签名方式
     *
     */
    public static String sign_type = "RSA2";

    /**
     * 字码编码格式
     */
    public static String charset = "utf-8";

    /**
     * 回调的地址
     */
    public static String notifyUrl="http://leige.qicp.vip/pay/callback/";

}
