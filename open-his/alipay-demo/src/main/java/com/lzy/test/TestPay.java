package com.lzy.test;

import com.lzy.pay.PayService;

import java.util.Map;

/**
 * @program: open-his
 * @description: 测试支付
 * @author: lzy
 * @create: 2021-04-08 17:28
 **/
public class TestPay {
    public static void main(String[] args) {
        String outTradeNo="OD123445577123125656";
        String subject="iphone专用平台";
        String totalAmount="9999";
        String undiscountableAmount=null;
        String body="买药用的";
        //支付回调的地址
        String notifyUrl="http://127.0.0.1:1000/pay/callBack"+outTradeNo;
        Map<String, Object> pay = PayService.pay(outTradeNo, subject, totalAmount, undiscountableAmount, body, notifyUrl);
        System.out.println(pay);

    }
}
