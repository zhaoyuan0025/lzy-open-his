package com.lzy.controller.system;

import cn.hutool.core.date.DateUtil;
import com.lzy.aspectj.annotation.Log;
import com.lzy.aspectj.enums.BussinessType;
import com.lzy.config.shiro.ActiverUser;
import com.lzy.constants.Constants;
import com.lzy.constants.HttpStatus;
import com.lzy.domain.LoginInfo;
import com.lzy.domain.Menu;
import com.lzy.dto.LoginBodyDto;
import com.lzy.domain.SimpleUser;
import com.lzy.service.LoginInfoService;
import com.lzy.service.MenuService;
import com.lzy.utils.AddressUtils;
import com.lzy.utils.IpUtils;
import com.lzy.utils.ShiroSecurityUtils;
import com.lzy.vo.AjaxResult;
import com.lzy.vo.MenuTreeVo;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.log4j.Log4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: open-his
 * @description: 登录
 * @author: lzy
 * @create: 2020-09-28 15:45
 **/
@RestController
@RequestMapping("/login")
@Log4j
public class LoginController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private LoginInfoService loginInfoService;

    /**
     * 登录
     * @param loginBodyDto
     * @param request
     * @return
     */
    @PostMapping("/doLogin")
    public AjaxResult login(@RequestBody @Validated LoginBodyDto loginBodyDto, HttpServletRequest request){
        //默认是登录成功
        AjaxResult ajaxResult = AjaxResult.success();
        //得到用户名和密码
        String username = loginBodyDto.getUsername();
        String password = loginBodyDto.getPassword();

        //构造用户名和密码的token
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();

        //封装用户的登录信息
        LoginInfo loginInfo = createLoginInfo(request);
        loginInfo.setLoginAccount(loginBodyDto.getUsername());

        try {
            subject.login(token);
            //得到会话的token，存入redis
            Serializable webToken = subject.getSession().getId();
            System.out.println(webToken);
            ajaxResult.put(Constants.TOKEN,webToken);
            //登录的日志信息
            loginInfo.setLoginStatus(Constants.LOGIN_SUCCESS);
            loginInfo.setUserName(ShiroSecurityUtils.getCurrentUserName());
            loginInfo.setMsg("登陆成功");

        } catch (AuthenticationException e) {
            //登录失败
            log.error("用户名或者密码不正确");
            ajaxResult = AjaxResult.error(HttpStatus.ERROR,"用户名或者密码不正确");
            e.printStackTrace();
        }

        //保存到数据库
        loginInfoService.insertLoginInfo(loginInfo);
        return ajaxResult;
    }

    /**
     * 构造LoginInfo
     * @param request
     * @return
     */
    private LoginInfo createLoginInfo(HttpServletRequest request) {
        LoginInfo loginInfo=new LoginInfo();
        UserAgent userAgent= UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        //获取ID地址
        String ipAddr= IpUtils.getIpAddr(request);
        //获取操作系统
        String os=userAgent.getOperatingSystem().getName();
        //获取浏览器类型
        String browser=userAgent.getBrowser().getName();
        //获取登陆地址
        String location= AddressUtils.getRealAddressByIP(ipAddr);

        loginInfo.setIpAddr(ipAddr);
        loginInfo.setLoginLocation(location);
        loginInfo.setOs(os);
        loginInfo.setBrowser(browser);
        loginInfo.setLoginTime(DateUtil.date());
        loginInfo.setLoginType(Constants.LOGIN_TYPE_SYSTEM);
        return loginInfo;
    }


    /**
     * 获取登录用户的信息
     * @return
     */
    @GetMapping("/getInfo")
    public AjaxResult getInfo(){
        Subject subject = SecurityUtils.getSubject();
        ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
        //登录成功
        AjaxResult result = AjaxResult.success();
        result.put("username",activerUser.getUser().getUserName());
        result.put("picture", activerUser.getUser().getPicture());
        result.put("roles", activerUser.getRoles());
        result.put("permissions", activerUser.getPermissions());
        return result;
    }

    /**
     * 退出
     * @return
     */
    @PostMapping("/logout")
    @Log(title = "用户退出",businessType = BussinessType.OTHER)
    public AjaxResult logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return AjaxResult.success("用户退出成功");
    }

    /**
     * 获取登录用户的菜单信息
     * @return
     */
    @GetMapping("/getMenus")
    public AjaxResult getMenus(){
        Subject subject = SecurityUtils.getSubject();
        ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
        //判断是否是超级管理员
        boolean isAdmin = activerUser.getUser().getUserType().equals(Constants.USER_ADMIN);
        SimpleUser simpleUser = null;
        //判断，如果不是超级管理员
        if(!isAdmin){
            //构造用户的传输对象
            simpleUser = new SimpleUser(activerUser.getUser().getUserId(),activerUser.getUser().getUserName());
        }
        //查询菜单
        List<Menu> menus = menuService.selectMenuTree(isAdmin,simpleUser);
        List<MenuTreeVo> menuTreeVos = new ArrayList<>();
        for (Menu menu : menus) {
            menuTreeVos.add(new MenuTreeVo(menu.getMenuId().toString(),menu.getPath()));

        }
        return AjaxResult.success("菜单查询成功",menuTreeVos);
    }
}
