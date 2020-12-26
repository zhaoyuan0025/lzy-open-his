package com.lzy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzy.constants.Constants;
import com.lzy.domain.Menu;
import com.lzy.dto.MenuDTO;
import com.lzy.mapper.MenuMapper;
import com.lzy.pojo.SimpleUser;
import com.lzy.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
  *
  * @author lzy
  */
@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuMapper menuMapper;

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

    @Override
    public List<Menu> listAllMenus(MenuDTO menuDto) {
        return null;
    }

    @Override
    public Menu getOne(Long menuId) {
        return null;
    }

    @Override
    public int addMenu(MenuDTO menuDto) {
        return 0;
    }

    @Override
    public int updateMenu(MenuDTO menuDto) {
        return 0;
    }

    @Override
    public int deleteMenuById(Long menuId) {
        return 0;
    }

    @Override
    public boolean hasChildByMenuId(Long menuId) {
        return false;
    }
}
