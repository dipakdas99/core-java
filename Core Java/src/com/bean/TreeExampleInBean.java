package com.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MyTreeNode<T>{
    private T data = null;
    private List<MyTreeNode<T>> children = new ArrayList<>();
    private MyTreeNode<T> parent = null;
//    private MyTreeNode<T> commonAncestor = null;
    public MyTreeNode(T data) {
        this.data = data;
    }

    public void addChild(MyTreeNode<T> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(T data) {
        MyTreeNode<T> newChild = new MyTreeNode<>(data);
        this.addChild(newChild);
    }

    public void addChildren(List<MyTreeNode<T>> children) {
        for(MyTreeNode<T> t : children) {
            t.setParent(this);
        }
        this.children.addAll(children);
    }

    public List<MyTreeNode<T>> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private void setParent(MyTreeNode<T> parent) {
        this.parent = parent;
    }

    public MyTreeNode<T> getParent() {
        return parent;
    }
}


public class TreeExampleInBean {
	public static void main(String[] args) {
		MyTreeNode<String> root = new MyTreeNode<>("Root");

		MyTreeNode<String> child1 = new MyTreeNode<>("Child1");
		child1.addChild("Grandchild1");
		child1.addChild("Grandchild2");
		MyTreeNode<String> child2 = new MyTreeNode<>("Child2");
		child2.addChild("Grandchild3");

		root.addChild(child1);
		root.addChild(child2);
		root.addChild("Child3");

		root.addChildren(Arrays.asList(
		        new MyTreeNode<>("Child4"),
		        new MyTreeNode<>("Child5"),
		        new MyTreeNode<>("Child6")
		));

		for(MyTreeNode node : root.getChildren()) {
		    System.out.println(node.getData());
		}
		System.out.println("NextLine");
		for (MyTreeNode node : child1.getChildren()){
			System.out.println(node.getData());
		}
		System.out.println("NextLine");
		System.out.println(child2.getParent().getData());
	}
}
