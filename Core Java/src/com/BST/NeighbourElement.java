package com.BST;

import com.BST.Node;

public class NeighbourElement {
	Node root;
	static int min_diff, min_diff_key;
	public static void main(String[] args) {
		NeighbourElement tree = new NeighbourElement();
		
		tree.root = new Node(5);
		tree.root.left = new Node(1);
		tree.root.left.right = new Node(3);
		tree.root.left.right.right = new Node(7);
		tree.root.left.right.right.right = new Node(9);
		
		int n = tree.findMaxForKey(tree.root,8,6);
		System.out.println(n);
	}

	private int findMaxForKey(Node node, int n, int size) {
		 // Initialize minimum difference 
	    min_diff = 999999999; min_diff_key = -1; 
	    // Find value of min_diff_key (Closest key 
	    // in tree with k) 
	    maxDiffUtil(root, n); 
	   
	    return min_diff_key; 
		
	}
	private void maxDiffUtil(Node ptr, int k) {
		if (ptr == null) 
	        return ; 
	    // If k itself is present 
	    if (ptr.key == k) 
	    { 
	        min_diff_key = k; 
	        return; 
	    } 
	    // update min_diff and min_diff_key by checking 
	    // current node value 
	    if (min_diff > Math.abs(ptr.key - k)) 
	    { 
	        min_diff = Math.abs(ptr.key - k); 
	        min_diff_key = ptr.key; 
	    } 
	    // if k is less than ptr.key then move in 
	    // left subtree else in right subtree 
	    if (k < ptr.key) 
	        maxDiffUtil(ptr.left, k); 
	    else
	        maxDiffUtil(ptr.right, k); 
	}

}
