package com.BST;

import com.BST.Node;

public class ConvertLevelOrderTraversalToBST {
	Node root;
	public static void main(String[] args) {
		ConvertLevelOrderTraversalToBST tree = new ConvertLevelOrderTraversalToBST();
		Node temp = null;
		int arr[] = {7, 4, 12, 3, 6, 8, 1, 5, 10};
		temp = insertLevelOrder(tree.root, arr, 0);
		inorder(temp);
	}
	private static Node insertLevelOrder(Node root, int[] arr, int i) {
		if (i < arr.length) { 
			Node temp = new Node(arr[i]); 
			root = temp; 
			// insert left child 
			root.left = insertLevelOrder( root.left, arr,2 * i + 1); 
			// insert right child 
			root.right = insertLevelOrder(root.right, arr, 2 * i + 2); 
		} 
		return root;
	}
	static void inorder(Node temp){
		inorder(temp.left);
		System.out.print(temp.key);
		inorder(temp.right);
	}
}
