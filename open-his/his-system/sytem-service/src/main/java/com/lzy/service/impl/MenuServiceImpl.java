package com.lzy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzy.constants.Constants;
import com.lzy.pojo.SimpleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzy.mapper.MenuMapper;
import com.lzy.domain.Menu;
import com.lzy.service.MenuService;
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
}
