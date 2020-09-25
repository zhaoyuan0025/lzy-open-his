package com.lzy.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: open-his
 * @description: 构造菜单返回给前台
 * @author: lzy
 * @create: 2020-09-25 19:45
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuTreeVo {

    private String id;

    private String serPath;

    private boolean show = true;

    public MenuTreeVo(String id, String serPath) {
        this.id = id;
        this.serPath = serPath;
    }

}
