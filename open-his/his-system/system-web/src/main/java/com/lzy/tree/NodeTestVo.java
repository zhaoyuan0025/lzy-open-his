package com.lzy.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: open-his
 * @description: 实体类
 * @author: lzy
 * @create: 2021-02-26 11:47
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NodeTestVo extends NodeHelper{

    private String text;

    private String url;

    public NodeTestVo(Integer id, Integer parentId, String text, String url) {
        super();
        this.id = id;
        this.parentId = parentId;
        this.text = text;
        this.url = url;
    }

}
