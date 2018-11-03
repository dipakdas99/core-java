package com.BST;

import com.BST.Node;

public class CountLeaveNode {
	Node root;
	
	protected int countLeave(Node node){
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		else
			return countLeave(node.left) + countLeave(node.right);
	}
	
	public static void main(String[] args) {
		CountLeaveNode tree = new CountLeaveNode();
		tree.root = new Node(1); 
	    tree.root.left = new Node(2); 
	    tree.root.right = new Node(3); 
	    tree.root.left.left = new Node(4); 
	    tree.root.left.right = new Node(5);
	    System.out.println(tree.countLeave(tree.root));
	}
}
