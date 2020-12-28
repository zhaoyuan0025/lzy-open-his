package com.lzy.controller.system;

import com.lzy.constants.Constants;
import com.lzy.domain.Menu;
import com.lzy.dto.MenuDTO;
import com.lzy.service.MenuService;
import com.lzy.utils.ShiroSecurityUtils;
import com.lzy.vo.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: open-his
 * @description: 菜单管理
 * @author: lzy
 * @create: 2020-12-29 00:43
 **/
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 查询所有的菜单以及权限信息
     * @param menuDTO
     * @return
     */
    @GetMapping("/listAllMenus")
    public AjaxResult listAllMenus(MenuDTO menuDTO){
        List<Menu> menus = menuService.listAllMenus(menuDTO);
        return AjaxResult.success(menus);
    }

    /**
     * 查询菜单的下拉树
     * @return
     */
    @GetMapping("/selectMenuTree")
    public AjaxResult selectMenuTree(){
        MenuDTO menuDTO = new MenuDTO();
        //只查询可用的
        menuDTO.setStatus(Constants.STATUS_TRUE);
        List<Menu> menuList = menuService.listAllMenus(menuDTO);
        return AjaxResult.success(menuList);
    }

    /**
     * 添加菜单
     * @param menuDTO
     * @return
     */
    @PostMapping("addMenu")
    public AjaxResult addMenu(@Validated @RequestBody MenuDTO menuDTO){
        menuDTO.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        int menu = menuService.addMenu(menuDTO);
        return AjaxResult.toAjax(menu);
    }

    /**
     * 修改菜单
     * @param menuDTO
     * @return
     */
    @PutMapping("/updateMenu")
    public AjaxResult updateMenu(@Validated @RequestBody MenuDTO menuDTO){
        menuDTO.setSimpleUser(ShiroSecurityUtils.getCurrentSimpleUser());
        int i = menuService.updateMenu(menuDTO);
        return AjaxResult.toAjax(i);
    }

    /**
     * 通过ID查询
     * @param menuId
     * @return
     */
    @GetMapping("/getById/{menuId}")
    public AjaxResult getById(@PathVariable Long menuId){
        Menu menu = menuService.getOne(menuId);
        return AjaxResult.success(menu);
    }

    /**
     * 通过ID删除
     * @param menuId
     * @return
     */
    @DeleteMapping("/deleteMenuById/{menuId}")
    public AjaxResult deleteMenuById(@PathVariable Long menuId){
        //先判断当前的菜单有没有子节点菜单
        boolean b = menuService.hasChildByMenuId(menuId);
        if(b){
            //如果有字节点菜单
            return AjaxResult.fail("请先删除该菜单下的子菜单！");
        }
        int i = menuService.deleteMenuById(menuId);
        return AjaxResult.toAjax(i);
    }
}
