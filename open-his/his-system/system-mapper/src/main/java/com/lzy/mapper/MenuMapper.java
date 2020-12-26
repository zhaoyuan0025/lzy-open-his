package com.lzy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lzy.domain.Menu;
import org.springframework.stereotype.Component;

/**
 * 菜单权限
 * @author 刘少
 */
@Component
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 根据ID查询子节点个数
     * @param menuId
     * @return
     */
    Long queryChildCountByMenuId(Long menuId);
}