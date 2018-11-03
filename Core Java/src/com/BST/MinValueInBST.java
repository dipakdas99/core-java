package com.BST;

import com.BST.Node;

public class MinValueInBST {
	Node root;
	private int findMinValue(Node node){
		int min = node.key;
		while (node.left != null) {
			min = node.left.key;
			node = node.left;
		}
		return min;
	}
	public static void main(String[] args) {
		MinValueInBST tree = new MinValueInBST();
		tree.root = new Node(20);
		tree.root.left = new Node(10);
		tree.root.left.right = new Node(8);
		tree.root.left.left = new Node (5);
		tree.root.right = new Node(30);
		tree.root.right.right = new Node(32);
		tree.root.right.left = new Node(25);
		tree.root.right.left.left = new Node(22);
		
		int min = tree.findMinValue(tree.root);
		System.out.println(min);

	}

}
