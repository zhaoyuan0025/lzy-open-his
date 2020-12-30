package com.lzy.controller.system;

import com.lzy.domain.Role;
import com.lzy.dto.RoleDTO;
import com.lzy.service.RoleService;
import com.lzy.utils.ShiroSecurityUtils;
import com.lzy.vo.AjaxResult;
import com.lzy.vo.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: open-his
 * @description: 角色管理
 * @author: lzy
 * @create: 2020-12-31 01:05
 **/
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 分页查询
     * @param roleDto
     * @return
     */
    @GetMapping("listRoleForPage")
    public AjaxResult listRoleForPage(RoleDTO roleDto){
        DataGridView gridView = roleService.listRolePage(roleDto);
        return AjaxResult.success("查询成功",gridView.getData(),gridView.getTotal());
    }

    /**
     * 不分页面查询有效的
     */
    @GetMapping("/selectAllRoles")
    public AjaxResult selectAllRoles(){
        List<Role> lists=roleService.listAllRoles();
        return AjaxResult.success(lists);
    }

    /**
     * 通过id查询你
     * @param roleId
     * @return
     */
    @GetMapping("/getRoleById/{roleId}")
    public AjaxResult getRoleById(@PathVariable Long roleId){
        Role role=roleService.getOne(roleId);
        return AjaxResult.success(role);
    }

    /**
     * 添加
     */
    @PostMapping("/addRole")
    public AjaxResult addRole(@Validated @RequestBody RoleDTO roleDto){
        roleDto.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        return AjaxResult.toAjax(roleService.addRole(roleDto));
    }

    /**
     * 修改
     */
    @PutMapping("/updateRole")
    public AjaxResult updateRole(@Validated RoleDTO roleDto){
        roleDto.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        return AjaxResult.toAjax(roleService.updateRole(roleDto));
    }

    /**
     * 删除
     * @param roleIds
     * @return
     */
    @DeleteMapping("/deleteRoleByIds/{roleIds}")
    public AjaxResult deleteRoleByIds(@PathVariable Long[] roleIds){
        return AjaxResult.toAjax(roleService.deleteRoleByIds(roleIds));
    }

}
