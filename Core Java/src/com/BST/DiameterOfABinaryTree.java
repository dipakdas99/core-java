package com.BST;

import com.BST.Node;

public class DiameterOfABinaryTree {
	Node root;

	protected int findDiameter(Node root){
		
		if (root == null)
			return 0;
		int l_height = height(root.left);
		int r_height = height(root.right);
		
		int l_diameter = findDiameter(root.left);
		int r_diameter = findDiameter(root.right);
		
		return Math.max(l_height+r_height+1, Math.max(l_diameter,r_diameter));
	}
	private int height(Node node) {
		if (node == null)
			return 0;
		return 1+Math.max(height(node.left), height(node.right));
	}
	public static void main(String[] args) {
		DiameterOfABinaryTree tree = new DiameterOfABinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(20);
		tree.root.right = new Node(30);
		tree.root.left.left = new Node(40);
		tree.root.left.right = new Node(60);
		
		System.out.println(tree.findDiameter(tree.root));
	}

}
