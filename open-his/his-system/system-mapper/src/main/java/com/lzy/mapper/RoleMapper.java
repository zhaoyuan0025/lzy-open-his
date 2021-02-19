package com.lzy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzy.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: open-his
 * @description: mapper接口
 * @author: lzy
 * @create: 2020-12-30 00:09
 **/
@Component
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * 删除菜单角色权限
     * @param ids
     */
    void deleteRoleMenuByRoleIds(List<Long> ids);

    /**
     * 删除角色
     * @param ids
     */
    void deleteRoleUserByRoleIds(List<Long> ids);

    /**
     * 保存角色和菜单之关的关系
     * @param roleId
     * @param menuId
     */
    void saveRoleMenu(Long roleId, Long menuId);

    /**
     * 根据用户IDS删除sys_role_user里面的数据
     * @param ids
     */
    void deleteRoleUserByUserIds(@Param("ids") List<Long> ids);

    /**
     * 根据菜单权限ID删除sys_role_menu
     */
    void deleteRoleMenuByMenuIds(@Param("ids") List<Long> ids);

}
