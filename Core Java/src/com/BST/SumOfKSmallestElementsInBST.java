package com.BST;

import com.BST.Node;
import java.util.ArrayList;
public class SumOfKSmallestElementsInBST {
	Node root;
	int i=0;
	ArrayList<Integer> list = new ArrayList<Integer>();
	private void findKthSmallestElement(Node node, int k){
		if (node == null)
			return;
		inorder(node, k);
		int sum = 0;
		for (Integer integer : list) {
			sum += integer;
		}
		System.out.println(sum);
	}
	int count = 1;
	private void inorder(Node node, int k) {
		if (node == null)
			return;
		inorder(node.left, k);
		if (count <= k)
			list.add(node.key);
		count++;
		inorder(node.right, k);
	}
	public static void main(String[] args) {
		SumOfKSmallestElementsInBST tree = new SumOfKSmallestElementsInBST();
		tree.root = new Node(20);
		tree.root.left = new Node(10);
		tree.root.left.right = new Node(12);
		tree.root.left.left = new Node (5);
		tree.root.right = new Node(30);
		tree.root.right.right = new Node(32);
		tree.root.right.left = new Node(25);
		
		tree.findKthSmallestElement(tree.root, 3);
	}

}
