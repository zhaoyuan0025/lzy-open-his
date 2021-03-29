package com.lzy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: open-his
 * @description: 树形构造器
 * @author: lzy
 * @create: 2021-02-26 11:45
 **/
public class TreeBuilder {

    List<? extends NodeHelper> nodes = new ArrayList<>();

    public TreeBuilder(List<? extends NodeHelper> nodes) {
        super();
        this.nodes = nodes;
    }


    /**
     * 构建树形结构
     *
     * @return
     */
    public List<NodeHelper> buildTree() {
        List<NodeHelper> treeNodes = new ArrayList<>();
        List<NodeHelper> rootNodes = getRootNodes();
        for (NodeHelper rootNode : rootNodes) {
            buildChildNodes(rootNode);
            treeNodes.add(rootNode);
        }
        return treeNodes;
    }

    /**
     * 递归子节点
     *
     * @param node
     */
    public void buildChildNodes(NodeHelper node) {
        List<NodeHelper> children = getChildNodes(node);
        if (!children.isEmpty()) {
            for (NodeHelper child : children) {
                buildChildNodes(child);
            }
            node.setChild(children);
        }
    }
    /**
     * 获取父节点下所有的子节点
     *
     * @param pnode
     * @return
     */
    public List<NodeHelper> getChildNodes(NodeHelper pnode) {
        List<NodeHelper> childNodes = new ArrayList<>();

        for (NodeHelper n : nodes) {
            if (pnode.getId().equals(n.getParentId())) {
                childNodes.add(n);
            }
        }
        return childNodes;
    }
    /**
     * 判断是否为根节点
     *
     * @param node
     * @return
     */
    public boolean rootNode(NodeHelper node) {
        boolean isRootNode = true;
        for (NodeHelper n : nodes) {
            if (node.getParentId().equals(n.getId())) {
                isRootNode = false;
                break;
            }
        }
        return isRootNode;
    }

    /**
     * 获取集合中所有的根节点
     *
     * @return
     */
    public List<NodeHelper> getRootNodes() {
        List<NodeHelper> rootNodes = new ArrayList<>();
        for (NodeHelper n : nodes) {
            if (rootNode(n)) {
                rootNodes.add(n);
            }
        }
        return rootNodes;
    }

}
