package com.lzy.tree;

import lombok.Data;

import java.util.List;

/**
 * @program: open-his
 * @description: 树形结构基类
 * @author: lzy
 * @create: 2021-02-26 11:43
 **/
@Data
public class NodeHelper {


    public Integer id;

    public Integer parentId;

    /**
     * 子节点
     */
    public List<? extends NodeHelper> child;
}
