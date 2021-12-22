package com.lzy.controller.system;

import cn.hutool.core.date.DateUtil;
import com.lzy.aspectj.annotation.Log;
import com.lzy.aspectj.enums.BussinessType;
import com.lzy.common.minio.util.VerifyUtil;
import com.lzy.common.redis.service.RedisService;
import com.lzy.config.shiro.ActiverUser;
import com.lzy.constants.Constants;
import com.lzy.constants.HttpStatus;
import com.lzy.domain.LoginInfo;
import com.lzy.domain.Menu;
import com.lzy.domain.SimpleUser;
import com.lzy.dto.LoginBodyDto;
import com.lzy.service.LoginInfoService;
import com.lzy.service.MenuService;
import com.lzy.utils.AddressUtils;
import com.lzy.utils.IpUtils;
import com.lzy.utils.ShiroSecurityUtils;
import com.lzy.vo.AjaxResult;
import com.lzy.vo.MenuTreeVo;
import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
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
@Slf4j
public class LoginController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private LoginInfoService loginInfoService;

    @Autowired
    private RedisService redisService;

    /**
     * 登录
     * @param loginBodyDto
     * @param request
     * @return
     */
    @PostMapping("/doLogin")
    public AjaxResult login(@RequestBody @Validated LoginBodyDto loginBodyDto, HttpServletRequest request){
        //校验验证码 先比对验证码 不正确是出响应的thi上 yonghu
//        String catchCode = redisService.get(loginBodyDto.getUuid() + Constants.CODE_KEY);
//        if (StringUtils.isEmpty(catchCode)){
//            throw new MedicalException("验证码已经过期！");
//        }
//        if (ObjectUtil.isEmpty(loginBodyDto.getCode()) && !loginBodyDto.getCode().equals(catchCode)){
//            throw new MedicalException("验证码不正确!!!");
//        }
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
            System.out.println("用户名或者密码不正确");
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


    /**
     * 生成验证码的接口
     *
     * @param response Response对象
     * @param request  Request对象
     * @throws Exception
     */
    @PostMapping("/getCode")
    public void getCode(HttpServletResponse response, HttpServletRequest request) throws Exception {
        // 获取到session
        HttpSession session = request.getSession();
        // 取到sessionid
        String id = session.getId();

        log.info("所生成的sessionID为:>>>>>>>>>>>>>>>>>:{}" ,id);
        // 利用图片工具生成图片
        // 返回的数组第一个参数是生成的验证码，第二个参数是生成的图片
        Object[] objs = VerifyUtil.newBuilder()
                //设置图片的宽度
                .setWidth(120)
                //设置图片的高度
                .setHeight(35)
                //设置字符的个数
                .setSize(6)
                //设置干扰线的条数
                .setLines(10)
                //设置字体的大小
                .setFontSize(30)
                //设置是否需要倾斜
                .setTilt(true)
                //设置验证码的背景颜色
                .setBackgroundColor(Color.LIGHT_GRAY)
                //构建VerifyUtil项目
                .build()
                //生成图片
                .createImage();
        // 将验证码存入Session
        session.setAttribute("SESSION_VERIFY_CODE_" + id, objs[0]);
        // 打印验证码
        log.info("该验证码为>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>:{}",objs[0]);

        // 设置redis值的序列化方式
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
        // 在redis中保存一个验证码最多尝试次数
        // 这里采用的是先预设一个上限次数，再以reidis decrement(递减)的方式来进行验证
        // 这样有个缺点，就是用户只申请验证码，不验证就走了的话，这里就会白白占用5分钟的空间，造成浪费了
        // 为了避免以上的缺点，也可以采用redis的increment（自增）方法，只有用户开始在做验证的时候设置值，
        //    超过多少次错误，就失效；避免空间浪费
        redisService.set(("VERIFY_CODE_" + id), "3", 5 * 60);

        //将验证码存入redis中
        redisService.set("code_"+id,objs[0],5*60);

        // 将图片输出给浏览器 以流的形式你返回给前端
        BufferedImage image = (BufferedImage) objs[1];
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
    }

}
