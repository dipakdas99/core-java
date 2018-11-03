package com.BST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.BST.Node;

public class ReverseLevelOrderTraversal {
	Node root;
	
	protected void reverseLevelOrder(Node root){
		Queue<Node> q1 = new LinkedList<Node>();
		Stack<Node> s1 = new Stack<Node>();
		q1.offer(root);
		while (!q1.isEmpty()){
			root = q1.poll();
			s1.push(root);
			if (root.right != null)
				q1.offer(root.right);
			if (root.left != null)
				q1.offer(root.left);
		}
		
		while (!s1.isEmpty()){
			root = s1.pop();
			System.out.print(root.key+" ");
		}
	}
	
	public static void main(String[] args) {
		ReverseLevelOrderTraversal tree = new ReverseLevelOrderTraversal();
		
		tree.root = new Node(4); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(5); 
        tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(3);
        
        
        tree.reverseLevelOrder(tree.root);
	}

}
