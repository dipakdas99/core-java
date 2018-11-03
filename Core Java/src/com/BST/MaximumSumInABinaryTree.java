package com.BST;

import com.BST.Node;

public class MaximumSumInABinaryTree {
	Node root;
	
	public static void main(String[] args) {
		MaximumSumInABinaryTree tree = new MaximumSumInABinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(6);
		tree.root.left.right.left = new Node(7);
		tree.root.right.left = new Node(9);
		
		System.out.println(tree.findMaxSum(tree.root));
	}
	
	class Result{
		public int val;
	}
	
	
	protected int findMaxSum(Node node) {
		
		Result res = new Result();
		res.val = Integer.MIN_VALUE;
		findMaxUtil(node, res);
		return res.val;
	}
	private int findMaxUtil(Node node, Result res) {
		if ( node == null )
			return 0;
		
		int l_sum = findMaxUtil (node.left, res);
		int r_sum = findMaxUtil (node.right, res); 
		
		int max_single = Math.max(Math.max(l_sum, r_sum)+ node.key, node.key);
		
		int max_top = Math.max(max_single, l_sum+r_sum+node.key);
		
		res.val = Math.max(res.val, max_top);
		
		return max_single;
	}

}
