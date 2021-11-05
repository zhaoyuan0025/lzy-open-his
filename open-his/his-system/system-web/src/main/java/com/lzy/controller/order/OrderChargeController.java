package com.lzy.controller.order;

import com.lzy.utils.IdWorker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: open-his
 * @description: 订单支付
 * @author: lzy
 * @create: 2021-04-16 10:06
 **/
@RestController
@RequestMapping("/order")
public class OrderChargeController {

    public static void main(String[] args) {
        IdWorker idWorker = new IdWorker();
        for (int i=0;i<5;i++){
            String id = idWorker.nextId()+"";
            System.out.println("id ======== " + id);

        }
    }

}
