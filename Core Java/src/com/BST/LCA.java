package com.BST;

import com.BST.Node;

public class LCA {
	Node root;
	
	protected Node findLCA(Node root, int n1, int n2){
		if (root == null)
			return null;
		if(root.key > Math.max(n1, n2))
			return findLCA(root.left, n1, n2);
		else if (root.key < Math.min(n1, n2))
			return findLCA(root.right, n1, n2);
		else
			return root;
	}
	
	public static void main(String[] args) {
		LCA tree = new LCA();
		/*tree.root = new Node(20); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(22); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
        tree.root.left.right.left = new Node(10); 
        tree.root.left.right.right = new Node(14); */
		tree.root = new Node(5); 
        tree.root.left = new Node(4); 
        tree.root.right = new Node(6); 
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(3);
        tree.root.right.right = new Node(7);
        tree.root.right.right.right = new Node(8);
		Node ancestor = tree.findLCA(tree.root,2, 3);
		System.out.println(ancestor.key);
	}
}
