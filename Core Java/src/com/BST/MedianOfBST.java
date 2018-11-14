package com.BST;

import com.BST.Node;
import java.util.ArrayList;
public class MedianOfBST {
	Node root;
	ArrayList<Integer> list = new ArrayList<Integer>();
	int i=0;
	private void findMedian(Node node){
		if (node == null)
			return;
		inorder(node);
		int n = list.size();
		
		if (n%2 == 1){
			System.out.println(list.get(n/2));
		}else{
			int curr = n/2;
			int before = curr -1;
			curr = list.get(curr);
			before = list.get(before);
			int result = (curr+before)/2;
			System.out.println(result);
		}
	}
	private void inorder(Node node) {
		if (node == null)
			return;
		inorder(node.left);
		list.add(node.key);
		inorder(node.right);
		
	}
	public static void main(String[] args) {
		MedianOfBST tree = new MedianOfBST();
		tree.root = new Node(20);
		tree.root.left = new Node(10);
		tree.root.left.right = new Node(12);
		tree.root.left.left = new Node (5);
		tree.root.right = new Node(30);
		tree.root.right.right = new Node(32);
		tree.root.right.left = new Node(25);
		
		tree.findMedian(tree.root);
	}
	

}
