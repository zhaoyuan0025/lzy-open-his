package com.lzy.tree;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: open-his
 * @description: 测试
 * @author: lzy
 * @create: 2021-02-26 11:48
 **/
public class TestTree {
    public static void main(String[] args) {
        List<NodeTestVo> nodes = new ArrayList<>();
        NodeTestVo p1 = new NodeTestVo(1, 0, "1", "");
        NodeTestVo p6 = new NodeTestVo(2, 0, "2", "");
        NodeTestVo p7 = new NodeTestVo(201, 2, "201", "");
        NodeTestVo p2 = new NodeTestVo(101, 1, "101", "");
        NodeTestVo p3 = new NodeTestVo(102, 1, "102", "");
        NodeTestVo p4 = new NodeTestVo(10101, 101, "10101", "");
        NodeTestVo p5 = new NodeTestVo(10102, 101, "10102", "");
        nodes.add(p1);
        nodes.add(p2);
        nodes.add(p3);
        nodes.add(p4);
        nodes.add(p5);
        nodes.add(p6);
        nodes.add(p7);
        TreeBuilder treeBuilder = new TreeBuilder(nodes);
        List<NodeHelper> nodeVos = treeBuilder.buildTree();
        System.out.println(JSON.toJSONString(nodeVos));
    }
}
