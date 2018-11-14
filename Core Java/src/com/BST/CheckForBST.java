package com.BST;

import com.BST.Node;

public class CheckForBST {
	Node root;
	public boolean isBST(Node node, int min, int max){
		if (node == null)
			return true;
		if (node.key <= min || node.key > max)
			return false;
		return isBST(node.left, min, node.key) && isBST(node.right, node.key, max);
	}
	public static void main(String[] args) {
		CheckForBST tree = new CheckForBST();
		tree.root = new Node(20);
		tree.root.left = new Node(10);
		tree.root.left.right = new Node(12);
		tree.root.left.left = new Node (5);
		tree.root.right = new Node(30);
		tree.root.right.right = new Node(32);
		tree.root.right.left = new Node(25);
		
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		
		boolean flag = tree.isBST(tree.root, min, max);
		System.out.println(flag);
	}

}
