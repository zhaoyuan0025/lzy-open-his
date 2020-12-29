package com.lzy.service;

import com.lzy.domain.Role;
import com.lzy.dto.RoleDTO;
import com.lzy.vo.DataGridView;

import java.util.List;

/**
 * @program: open-his
 * @description: 角色的service接口
 * @author: lzy
 * @create: 2020-12-30 00:06
 **/
public interface RoleService {

    /**
     * 分页查询角色
     * @param roleDTO
     * @return
     */
    DataGridView listRolePage(RoleDTO roleDTO);

    /**
     * 查询所有可用角色
     * @return
     */
    List<Role> listAllRoles();

    /**
     * 根据ID查询角色
     * @param roleId
     * @return
     */
    Role getOne(Long roleId);

    /**
     * 添加一个角色
     * @param roleDTO
     * @return
     */
    int addRole(RoleDTO roleDTO);

    /**
     * 修改角色
     * @param roleDTO
     * @return
     */
    int updateRole(RoleDTO roleDTO);

    /**
     * 根据角色ID删除角色
     * @param roleIds
     * @return
     */
    int deleteRoleByIds(Long[] roleIds);

}
