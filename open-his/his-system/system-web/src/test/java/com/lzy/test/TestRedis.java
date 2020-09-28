package com.lzy.test;

import redis.clients.jedis.Jedis;

/**
 * @program: open-his
 * @description: 测试
 * @author: lzy
 * @create: 2020-09-29 00:10
 **/
public class TestRedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String ping = jedis.ping();
        System.out.println("连接成功"+ping);
    }
}
