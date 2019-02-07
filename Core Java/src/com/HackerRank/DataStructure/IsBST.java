package com.HackerRank.DataStructure;

public class IsBST {
	static class Node{
		Node left,right;
		int data;
		Node(int key){
			this.data = key;
			left = right =null;
		}
	}
	public Node root;
	public static void main(String[] args) {
		IsBST tree = new IsBST();
		tree.root = new Node(3);
		tree.root.left = new Node(5);
		tree.root.right = new Node(2);
		tree.root.left.left = new Node(1);
		tree.root.left.right = new Node(4);
		tree.root.right.left = new Node(6);
		tree.checkBST(tree.root);
	}
	private void checkBST(Node node) {
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		boolean flag = isTreeBST(node, min, max);
		if (flag){
			System.out.println("Yes");
		}else
			System.out.println("No");
		
	}
	private boolean isTreeBST(Node node, int min, int max) {
		if (node == null)
			return true;
		if (node.data <= min || node.data >= max)
			return false;
		return isTreeBST(node.left,min, node.data) && isTreeBST(node.right, node.data, max);
	}
}
