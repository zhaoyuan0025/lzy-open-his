package com.lzy.controller.system;

import com.lzy.config.shiro.ActiverUser;
import com.lzy.constants.Constants;
import com.lzy.constants.HttpStatus;
import com.lzy.domain.Menu;
import com.lzy.domain.User;
import com.lzy.dto.LoginBodyDto;
import com.lzy.pojo.SimpleUser;
import com.lzy.service.MenuService;
import com.lzy.service.UserService;
import com.lzy.vo.AjaxResult;
import com.lzy.vo.MenuTreeVo;
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

        try {
            subject.login(token);
            //得到会话的token，也就是存在redis里面的额
            Serializable webToken = subject.getSession().getId();
            ajaxResult.put(Constants.TOKEN,webToken);
        } catch (AuthenticationException e) {
            //登录失败
            log.error("用户名或者密码不正确");
            ajaxResult = AjaxResult.error(HttpStatus.ERROR,"用户名或者密码不正确");
            e.printStackTrace();
        }

        return ajaxResult;
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
