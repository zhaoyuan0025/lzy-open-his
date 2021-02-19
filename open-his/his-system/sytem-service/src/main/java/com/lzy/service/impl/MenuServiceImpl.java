package com.lzy.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzy.constants.Constants;
import com.lzy.domain.Menu;
import com.lzy.dto.MenuDTO;
import com.lzy.exception.MedicalException;
import com.lzy.mapper.MenuMapper;
import com.lzy.mapper.RoleMapper;
import com.lzy.pojo.SimpleUser;
import com.lzy.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
/**
  *
  * @author lzy
  */
@Service
@Slf4j
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Menu> selectMenuTree(boolean isAdmin, SimpleUser simpleUser) {
        QueryWrapper<Menu> qw = new QueryWrapper<>();
        //构造mp查询的条件
        //菜单是可用的状态
        qw.eq(Menu.COL_STATUS, Constants.STATUS_TRUE);
        //菜单的范围
        qw.in(Menu.COL_MENU_TYPE,Constants.MENU_TYPE_M,Constants.MENU_TYPE_C);
        //排序
        qw.orderByAsc(Menu.COL_PARENT_ID);
        if(isAdmin){
            //如果是超级管理员
            return menuMapper.selectList(qw);
        }else {
            //如果是普通用户,根据用户id插叙拥有的菜单信息
            return menuMapper.selectList(qw);
        }
    }

    /**
     * 查询所有的菜单
     * @param menuDto
     * @return
     */
    @Override
    public List<Menu> listAllMenus(MenuDTO menuDto) {
        QueryWrapper<Menu> qw = new QueryWrapper<>();
        //构造查询条件
        qw.like(StringUtils.isNotBlank(menuDto.getMenuName()), Menu.COL_MENU_NAME, menuDto.getMenuName());
        qw.eq(StringUtils.isNotBlank(menuDto.getStatus()), Menu.COL_STATUS, menuDto.getStatus());
        return menuMapper.selectList(qw);
    }

    /**
     * 通过ID查询
     * @param menuId
     * @return
     */
    @Override
    public Menu getOne(Long menuId) {
        return menuMapper.selectById(menuId);
    }

    /**
     * 添加菜单
     * @param menuDto
     * @return
     */
    @Override
    public int addMenu(MenuDTO menuDto) {
        //先通过ID查询
        Menu one = getOne(menuDto.getMenuId());
        if(one.getMenuId().equals(menuDto.getMenuId())){
            throw new MedicalException("该菜单已经存在");
        }

        Menu menu = new Menu();
        BeanUtil.copyProperties(menuDto,menu);
        //设置创建时间创建人
        menu.setCreateBy(menuDto.getSimpleUser().getUserName());
        menu.setCreateTime(DateUtil.date());
        return menuMapper.insert(menu);
    }

    /**
     * 更新
     * @param menuDto
     * @return
     */
    @Override
    public int updateMenu(MenuDTO menuDto) {
        Menu menu = new Menu();
        BeanUtil.copyProperties(menuDto, menu);
        //设置修改人
        menu.setUpdateBy(menuDto.getSimpleUser().getUserName());
        return menuMapper.updateById(menu);
    }

    /**
     * 删除 通过ID
     * @param menuId
     * @return
     */
    @Override
    public int deleteMenuById(Long menuId) {
        //先删除role_menu的中间表的数据【后面再加】
        //再删除菜单或权限
        //删除sys_role_menu中间表的数据[后面完成]
        roleMapper.deleteRoleMenuByMenuIds(Arrays.asList(menuId));
        return menuMapper.deleteById(menuId);
    }

    /**
     * 查询是否有子菜单
     * @param menuId
     * @return
     */
    @Override
    public boolean hasChildByMenuId(Long menuId) {
        return menuMapper.queryChildCountByMenuId(menuId) > 0L ? true : false;
    }

    /**
     * 根据角色id查询菜单角色的id
     * @param roleId
     * @return
     */
    @Override
    public List<Long> getMenusByRoleId(Long roleId) {
        List<Long> list =  menuMapper.getMenusByRoleId(roleId);
        return list;
    }

}
