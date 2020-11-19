package com.hbxy.ssm.admin.right.model;

import java.util.ArrayList;
import java.util.List;

//用于构造（权限资源树结构）
//第一层是子系统（或者是模块分组）
//第二层是应用模块
public class RightNode {

    private String id;

    private String label;

    //0-子系统 1-应用模块
    private String isModule = "0";

    private List<RightNode> children = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIsModule() {
        return isModule;
    }

    public void setIsModule(String isModule) {
        this.isModule = isModule;
    }

    public List<RightNode> getChildren() {
        return children;
    }

    public void setChildren(List<RightNode> children) {
        this.children = children;
    }
    //添加子节点
    public void addChildren(RightNode child) {
        this.children.add(child);
    }
}
