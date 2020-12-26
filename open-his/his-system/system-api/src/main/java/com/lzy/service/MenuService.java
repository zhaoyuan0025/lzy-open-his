package com.lzy.service;


import com.lzy.domain.Menu;
import com.lzy.dto.MenuDTO;
import com.lzy.pojo.SimpleUser;

import java.util.List;

/**
 * @author lzy
 */
public interface MenuService{

    /**
     * 查询菜单信息,如果是超级管理员就查询所有菜单
     * 普通用户就根据id关联角色和权限
     * @param isAdmin 是否是超级管理员
     * @param simpleUser
     * @return
     */
    List<Menu> selectMenuTree(boolean isAdmin, SimpleUser simpleUser);

    /**
     * 根据条件查询所有菜单
     * @param menuDto
     * @return
     */
    List<Menu> listAllMenus(MenuDTO menuDto);

    /**
     * 根据ID查询菜单和权限
     * @param menuId
     * @return
     */
    Menu getOne(Long menuId);

    /**
     * 添加菜单或权限
     * @param menuDto
     * @return
     */
    int addMenu(MenuDTO menuDto);

    /**
     * 修改菜单或权限
     * @param menuDto
     * @return
     */
    int updateMenu(MenuDTO menuDto);

    /**
     * 根据ID删除菜单或权限
     * @param menuId
     * @return
     */
    int deleteMenuById(Long menuId);

    /**
     * 根据菜单ID判断菜单是否有子节点
     * @param menuId
     * @return
     */
    boolean hasChildByMenuId(Long menuId);


}
