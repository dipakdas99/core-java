package com.BST;

import com.BST.Node;

public class HeightOfBinaryTree {
	Node root;
	protected int findHeight(Node root){
		if (root == null)
			return 0;
		int l_height = findHeight(root.left)+1;
		int r_height = findHeight(root.right)+1;
		return (l_height>r_height)?l_height:r_height;
	}
	public static void main(String[] args) {
		HeightOfBinaryTree tree = new HeightOfBinaryTree();
		tree.root = new Node(1); 
	    tree.root.left = new Node(2); 
	    tree.root.right = new Node(3); 
	    tree.root.left.left = new Node(4); 
	    tree.root.left.right = new Node(5);
		
	   int h = tree.findHeight(tree.root);
	   System.out.println(h);
	    
	}
}
