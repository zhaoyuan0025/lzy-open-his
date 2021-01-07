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

    /**
     * 保存角色和菜单之间的关系
     * @param roleId
     * @param menuIds
     * @return
     */
    @PostMapping("saveRoleMenu/{roleId}/{menuIds}")
    public AjaxResult saveRoleMenu(@PathVariable Long roleId,@PathVariable Long[] menuIds){
        /**
         * 因为我们用的路径参数，前端可能传过来的menuIds是一个空的，但是为空的话无法匹配上面的路径
         * 所以如果为空，我们让前端传一个-1过来，如果是-1说明当前角色一个权限也没有选择
         */
        if(menuIds.length==1&&menuIds[0].equals(-1L)){
            menuIds=new Long[]{};
        }
        this.roleService.saveRoleMenu(roleId, menuIds);
        return AjaxResult.success();
    }


}
