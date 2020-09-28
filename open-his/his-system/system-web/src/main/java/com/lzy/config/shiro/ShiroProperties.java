package com.lzy.config.shiro;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @program: open-his
 * @description: shiro的配置的参数
 * @author: lzy
 * @create: 2020-09-28 15:30
 **/
@ConfigurationProperties(value = "shiro")
@Data
public class ShiroProperties {

    /**
     * 密码加密方式
     */
    private String hashAlgorithmName="md5";
    /**
     * 密码散列次数
     */
    private Integer hashIterations=2;

    /**
     * 不拦击的路径
     */
    private String [] anonUrls;

    /**
     * 拦截的路径
     */
    private String [] authcUrls;

}
