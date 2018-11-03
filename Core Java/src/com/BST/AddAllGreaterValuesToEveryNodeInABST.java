package com.BST;

import com.BST.Node;

public class AddAllGreaterValuesToEveryNodeInABST {
	Node root;
	class Sum{
		int sum=0;
	}
	private void addMaxToNode(Node node){
		
		Sum s = new Sum();
		addMax(node,s);
		
	}
	
	private void addMax(Node node, Sum s) {
		if (node == null)
			return;
		addMax(node.right,s);
		s.sum = s.sum+node.key;
		node.key = s.sum;
		
		addMax(node.left,s);
	}

	public static void main(String[] args) {
		AddAllGreaterValuesToEveryNodeInABST tree = new AddAllGreaterValuesToEveryNodeInABST();
		tree.root = new Node(50);
		tree.root.left = new Node(30);
		tree.root.right = new Node(70);
		tree.root.left.left = new Node(20);
		tree.root.left.right = new Node(30);
		tree.root.right.left = new Node(60);
		tree.root.right.right = new Node(80);
		
		tree.addMaxToNode(tree.root);

	}

}
