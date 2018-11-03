package com.BST;
import com.BST.Node;
public class CheckBalancedTree {
	Node root;
	protected boolean isBalanced(Node root){
		if (root == null) {
            return true;
        }
        
        int heightOfLeft = getTreeHeight(root.left);
        int heightOfRight = getTreeHeight(root.right);
        
        return Math.abs(heightOfLeft - heightOfRight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}
	int getTreeHeight (Node root){
		if (root == null) {
            return 0;
        }
        
        int leftTreeHeight = getTreeHeight(root.left);
        int rightTreeHeight = getTreeHeight(root.right);
        
        return 1 + Math.max(leftTreeHeight, rightTreeHeight);
	}
	public static void main(String[] args) {
		CheckBalancedTree tree = new CheckBalancedTree();
		tree.root = new Node(10);
		tree.root.left = new Node(20);
		tree.root.right = new Node(30);
		tree.root.left.left = new Node(40);
		tree.root.left.right = new Node(60);

		System.out.println(tree.isBalanced(tree.root));
	}

}
