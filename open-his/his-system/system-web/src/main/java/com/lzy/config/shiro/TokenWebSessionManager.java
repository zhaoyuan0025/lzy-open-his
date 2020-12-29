package com.lzy.config.shiro;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.lzy.constants.Constants;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;
import java.util.UUID;

/**
 * @program: open-his
 * @description: 生成token
 * @author: lzy
 * @create: 2020-09-28 14:48
 **/
@Configuration
public class TokenWebSessionManager extends DefaultWebSessionManager {

    /**
     * 用户第一次访问的时候后台是没有token的下次访问的时候直接把token携带过来
     * 与redis的sessionId比对一样就登陆成功
     * @param request
     * @param response
     * @return
     */
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {

        //token生成密钥
//        private static String SING = "你的密钥";
        //从请求头获得token，没有就生成
        String token = WebUtils.toHttp(request).getHeader(Constants.TOKEN);
        if(StringUtils.hasText(token)){
            //判断请求头里面是否含有token
            return token;
        }else {
         //没有就生成，返回前台
//         return UUID.randomUUID().toString();
            String tokenWeb = JWT.create()
                    .withClaim("liuxiaoshao", "fhdjahfjkh")
                    .sign(Algorithm.HMAC256("fjafhdjhaahds5454"));

            return UUID.randomUUID().toString();
        }
    }
}
