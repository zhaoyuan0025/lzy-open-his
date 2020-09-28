package com.lzy.service;


import com.lzy.domain.Menu;
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

}
