package com.lzy.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

/**
 * @program: open-his
 * @description: 测试
 * @author: lzy
 * @create: 2020-09-29 00:10
 **/
public class TestRedis {
    public static void main(String[] args) {
//        Jedis jedis = new Jedis("127.0.0.1", 6379);
//        String ping = jedis.ping();
//        System.out.println("连接成功"+ping);


        //设置20秒的时间
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,60);
        //jwt生成token
        String token = JWT.create()
                //用户名
                .withClaim("username", "12345645")
                //设置过期时间
                .withExpiresAt(instance.getTime())
                //秘钥
                .sign(Algorithm.HMAC256("@qq.com"));
        System.out.println(token);
    }

    @Test
    public void test(){
        //创建验证对象
        JWTVerifier build = JWT.require(Algorithm.HMAC256("@qq.com")).build();
        DecodedJWT jwt = build.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2MDkyNjI4NTQsInVzZXJuYW1lIjoiMTIzNDU2NDUifQ.ZpXPj50cJk1h4sIhrkHt0MkyBY6z3ieRizoidOqNofk");
        System.out.println(jwt.getClaim("username").asString());

    }
}
