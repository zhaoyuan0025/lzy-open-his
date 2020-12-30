package com.lzy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzy.domain.Role;
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
}
