package com.lzy.config.shiro;

import com.alibaba.fastjson.JSON;
import com.lzy.constants.HttpStatus;
import com.lzy.vo.AjaxResult;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: open-his
 * @description: shiro的配置，判断用户是否进行了登录
 * @author: lzy
 * @create: 2020-09-28 14:40
 **/
public class ShiroLoginFilter extends FormAuthenticationFilter {
    //重写shiro的过滤器
    /**
     * 在访问controller层的时候判断是否登录，返回json，不进行重定向
     * @param request
     * @param response
     * @return true-继续往下执行，false-该filter过滤器已经处理，不继续执行其他过滤器
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        //未授权
        AjaxResult ajaxResult=AjaxResult.fail();
        ajaxResult.put("code", HttpStatus.UNAUTHORIZED);
        ajaxResult.put("msg", "登录认证失效，请重新登录!");
        httpServletResponse.getWriter().write(JSON.toJSON(ajaxResult).toString());
        return false;

    }
}
