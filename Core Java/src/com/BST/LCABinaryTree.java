package com.BST;

import com.BST.Node;

public class LCABinaryTree {
	Node root;
	protected Node findLCA(Node root, int n1, int n2){
		if (root == null){
			return null;
		}
		if (root.key == n1 || root.key == n2){
			return root;
		}
		Node left = findLCA(root.left, n1, n2);
		Node right = findLCA(root.right, n1, n2);
		
		if (left != null && right !=null){
			return root;
		}
		if (left == null && right == null){
			return null;
		}
		return left != null ? left : right;
		
	}
	public static void main(String[] args) {
		LCABinaryTree tree = new LCABinaryTree();

		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(6); 
		tree.root.right.right = new Node(7); 
		Node ancestor = tree.findLCA(tree.root,4, 6);
		System.out.println(ancestor.key);
	}

}
