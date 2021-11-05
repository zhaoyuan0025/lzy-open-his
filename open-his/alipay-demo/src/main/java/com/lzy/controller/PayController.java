package com.lzy.controller;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.lzy.config.AliPayConfig;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: open-his
 * @description: 支付的webcontroller
 * @author: lzy
 * @create: 2021-04-08 20:27
 **/
@RestController
@RequestMapping("/pay")
public class PayController {

    //输出日志
    static Log log = LogFactory.getLog("PayController");


    @PostMapping("/callBack/{orderId}")
    public void callBack(@PathVariable String orderId, HttpServletRequest request){
        Map<String, String> parameterMap = this.getParameterMap(request);
        System.out.println("回调的参数========："+parameterMap);
        String trade_status = parameterMap.get("trade_status");
        if ("TRADE_SUCCESS".equals(trade_status)) {
            try {
                //验证是否为支付宝发来的信息
                boolean singVerified = AlipaySignature.rsaCheckV1(parameterMap,
                        AliPayConfig.alipay_public_key, AliPayConfig.charset, AliPayConfig.sign_type);
                System.out.println(singVerified);//只有支付宝调用我们系统的接口才能去更新系统订单状态
                log.info("验证签名结果{}:" + singVerified);
                String refund_fee = parameterMap.get("refund_fee");
                if (StringUtils.isNotBlank(refund_fee)) {
                    //说明是退费
                    System.out.println("退费成功：退费的子订单ID为：" + parameterMap.get("out_biz_no"));
                    //更新订单状态
                } else {
                    //说明支付
                    System.out.println("收费成功，平台ID" + parameterMap.get("trade_no"));
                }
                System.out.println(JSON.toJSON(parameterMap));
            } catch (AlipayApiException e) {
                e.printStackTrace();
                log.error(orderId + "验证签名出现异常");
            }
        }else if("WAIT_BUYER_PAY".equals(trade_status)){
            System.out.println("二维码已扫描，等待支付");
        }
    }


    /**
     * 获取request中的参数集合转Map
     * Map<String,String> parameterMap = RequestUtil.getParameterMap(request)
     * @param request
     * @return
     */
    public Map<String, String> getParameterMap(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        Enumeration<String> paramNames = request.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String[] paramValues = request.getParameterValues(paramName);
            if (paramValues.length == 1) {
                String paramValue = paramValues[0];
                if (paramValue.length() != 0) {
                    map.put(paramName, paramValue);
                }
            }
        }
        return map;
    }



    /**
     * 密码验证
     *  @param pwd
     *  @return
     */
    public static void checkPwd(String pwd) {
        String regExp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9])(.{8,16})$";
        if(!pwd.matches(regExp)) {
            System.out.println("密码中必须包含字母(不区分大小写)、数字、特称字符，至少8个字符，最多16个字符");
        }else {
            System.out.println("密码校验过关！！！！");

        }
    }

    public static void main(String[] args) {
        checkPwd("Liu13755464546?");
    }

}
