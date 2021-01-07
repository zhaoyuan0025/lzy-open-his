package com.lzy.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lzy.constants.Constants;
import com.lzy.domain.Role;
import com.lzy.dto.RoleDTO;
import com.lzy.exception.MedicalException;
import com.lzy.mapper.RoleMapper;
import com.lzy.service.RoleService;
import com.lzy.vo.DataGridView;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    /**
     * 分页查询
     * @param roleDTO
     * @return
     */
    @Override
    public DataGridView listRolePage(RoleDTO roleDTO) {
        Page<Role> page = new Page<>(roleDTO.getPageNum(),roleDTO.getPageSize());
        //构造查询的条件
        QueryWrapper<Role> qw = new QueryWrapper<>();
        //模糊查询
        qw.like(StringUtils.isNotBlank(roleDTO.getRoleName()),Role.COL_ROLE_NAME,roleDTO.getRoleName());
        qw.like(StringUtils.isNotBlank(roleDTO.getRoleCode()),Role.COL_ROLE_CODE,roleDTO.getRoleCode());
        qw.eq(StringUtils.isNotBlank(roleDTO.getStatus()), Role.COL_STATUS, roleDTO.getStatus());
        qw.ge(null!= roleDTO.getBeginTime(), Role.COL_CREATE_TIME, roleDTO.getBeginTime());
        qw.le(null!= roleDTO.getEndTime(), Role.COL_CREATE_TIME, roleDTO.getEndTime());
        //排序
        qw.orderByAsc(Role.COL_ROLE_SORT);
        roleMapper.selectPage(page,qw);
        DataGridView dataGridView = new DataGridView(page.getTotal(), page.getRecords());
        return dataGridView;
    }

    /**
     * 查询所有角色
     * @return
     */
    @Override
    public List<Role> listAllRoles() {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(Role.COL_STATUS, Constants.STATUS_TRUE);
        queryWrapper.orderByAsc(Role.COL_ROLE_SORT);
        List<Role> roles = roleMapper.selectList(queryWrapper);
        return roles;
    }

    /**
     * 通过id查询
     * @param roleId
     * @return
     */
    @Override
    public Role getOne(Long roleId) {

        return roleMapper.selectById(roleId);
    }

    /**
     * 添加
     * @param roleDTO
     * @return
     */
    @Override
    public int addRole(RoleDTO roleDTO) {
        //先通过id查询角色
        Role roleById = getOne(roleDTO.getRoleId());
        if(roleById.getRoleName().equals(roleDTO.getRoleName())){
            throw new MedicalException("该角色已经存在，请勿重复添加");
        }
        Role role = new Role();
        BeanUtil.copyProperties(roleDTO,role);
        //创建人，创建时间
        role.setCreateBy(roleDTO.getSimpleUser().getUserName());
        role.setCreateTime(DateUtil.date());
        return roleMapper.insert(role);
    }

    /**
     * 修改
     * @param roleDTO
     * @return
     */
    @Override
    public int updateRole(RoleDTO roleDTO) {
        Role role =new Role();
        BeanUtil.copyProperties(roleDTO,role);
        //设置修改人
        role.setUpdateBy(roleDTO.getSimpleUser().getUserName());
        return roleMapper.updateById(role);
    }

    /**
     * 删除
     * @param roleIds
     * @return
     */
    @Override
    public int deleteRoleByIds(Long[] roleIds) {
        List<Long> ids = Arrays.asList(roleIds);
        Role role =new Role();
        if(null!=roleIds&&roleIds.length>0){
            //还要删除sys_role_menu
            this.roleMapper.deleteRoleMenuByRoleIds(ids);
            //还要删除sys_role_user
            this.roleMapper.deleteRoleUserByRoleIds(ids);
            return roleMapper.deleteBatchIds(ids);
        }
        return 0;

    }

    @Override
    public void saveRoleMenu(Long roleId, Long[] menuIds) {
        //根据角色ID删除sys_role_menu的数据
        roleMapper.deleteRoleMenuByRoleIds(Arrays.asList(roleId));
        for (Long menuId : menuIds) {
            roleMapper.saveRoleMenu(roleId,menuId);
        }

    }
}
