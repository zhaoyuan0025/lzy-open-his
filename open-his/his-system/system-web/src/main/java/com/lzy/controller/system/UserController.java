package com.lzy.controller.system;

import com.lzy.aspectj.annotation.Log;
import com.lzy.aspectj.enums.BussinessType;
import com.lzy.dto.UserDTO;
import com.lzy.service.UserService;
import com.lzy.utils.ShiroSecurityUtils;
import com.lzy.vo.AjaxResult;
import com.lzy.vo.DataGridView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @program: open-his
 * @description: 用户管理
 * @author: lzy
 * @create: 2021-02-19 17:57
 **/
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 分页查询
     */
    @GetMapping("/listUserForPage")
    public AjaxResult listUserForPage(UserDTO userDto){
        DataGridView gridView = userService.listUserForPage(userDto);
        return AjaxResult.success("查询成功",gridView.getData(),gridView.getTotal());
    }
    /**
     * 添加
     */
    @PostMapping("/addUser")
    @Log(title = "添加用户",businessType = BussinessType.INSERT)
    public AjaxResult addUser(@Validated UserDTO userDto) {
        //设置添加人
        userDto.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        return AjaxResult.toAjax(userService.addUser(userDto));
    }

    /**
     * 修改
     */
    @PutMapping("/updateUser")
    @Log(title = "修改用户",businessType = BussinessType.UPDATE)
    public AjaxResult updateUser(@Validated UserDTO userDto) {
        userDto.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        return AjaxResult.toAjax(userService.updateUser(userDto));
    }


    /**
     * 根据ID查询一个用户信息
     */
    @GetMapping("/getUserById/{userId}")
    public AjaxResult getUserById(@PathVariable @Validated @NotNull(message = "用户ID不能为空") Long userId) {
        return AjaxResult.success(userService.getOne(userId));
    }

    /**
     * 删除
     */
    @DeleteMapping("/deleteUserByIds/{userIds}")
    @Log(title = "删除用户",businessType = BussinessType.DELETE)
    public AjaxResult deleteUserByIds(@PathVariable @Validated @NotEmpty(message = "要删除的ID不能为空") Long[] userIds) {
        return AjaxResult.toAjax(userService.deleteUserByIds(userIds));
    }

    /**
     * 查询所有可用的用户
     */
    @GetMapping("/selectAllUser")
    public AjaxResult selectAllUser(){
        return AjaxResult.success(userService.getAllUsers());
    }

    /**
     * 重置密码
     */
    @PostMapping("/resetPwd/{userIds}")
    public AjaxResult resetPwd(@PathVariable Long[] userIds){
        if(userIds.length>0){
            userService.resetPassWord(userIds);
            return AjaxResult.success("重置成功");
        }
        return AjaxResult.fail("重置失败,没有选择用户");

    }

}
