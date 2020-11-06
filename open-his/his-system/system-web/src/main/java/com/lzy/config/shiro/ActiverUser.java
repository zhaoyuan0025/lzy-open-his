package com.lzy.config.shiro;

import com.lzy.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @program: open-his
 * @description: 构造一个user存放角色和权限
 * @author: lzy
 * @create: 2020-09-28 15:17
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActiverUser implements Serializable {

    private User user;
    /**
     * 角色
     */
    private List<String> roles = Collections.EMPTY_LIST;
    /**
     * 权限
     */
    private List<String> permissions = Collections.EMPTY_LIST;
}
