package com.BST;

import com.BST.Node;
import java.util.Stack;
public class ZigZagOrder {
	Node root;
	protected void printZigZag(Node root){
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(root);
		while ( !s1.isEmpty() || !s2.isEmpty() ){
			while ( !s1.isEmpty() ){
				root = s1.pop();
				System.out.print(root.key+" ");
				if ( root.left != null )
					s2.push(root.left);
				if ( root.right != null )
					s2.push(root.right);
			}
			while ( !s2.isEmpty() ){
				root = s2.pop();
				System.out.print(root.key+" ");
				if ( root.right != null )
					s1.push(root.right);
				if ( root.left != null )
					s1.push(root.left);
			}
		}
	}
	public static void main(String[] args) {
		ZigZagOrder tree = new ZigZagOrder();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(7);
		tree.root.left.right = new Node(6);
		tree.root.right.right = new Node(4);
		tree.root.right.left = new Node(5);
		
		tree.printZigZag(tree.root);
	}

}
