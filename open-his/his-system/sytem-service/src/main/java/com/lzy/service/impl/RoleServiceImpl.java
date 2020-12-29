package com.lzy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzy.domain.Role;
import com.lzy.dto.RoleDTO;
import com.lzy.mapper.RoleMapper;
import com.lzy.service.RoleService;
import com.lzy.vo.DataGridView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: open-his
 * @description: 实现类
 * @author: lzy
 * @create: 2020-12-30 00:08
 **/
@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public DataGridView listRolePage(RoleDTO roleDTO) {
        Page<Role> page = new Page<>(roleDTO.getPageNum(),roleDTO.getPageSize());
        //构造查询的条件
        QueryWrapper<Role> qw = new QueryWrapper<>();

        return null;
    }

    @Override
    public List<Role> listAllRoles() {
        return null;
    }

    @Override
    public Role getOne(Long roleId) {
        return null;
    }

    @Override
    public int addRole(RoleDTO roleDTO) {
        return 0;
    }

    @Override
    public int updateRole(RoleDTO roleDTO) {
        return 0;
    }

    @Override
    public int deleteRoleByIds(Long[] roleIds) {
        return 0;
    }
}
