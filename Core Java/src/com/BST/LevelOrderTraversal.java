package com.BST;

import java.util.LinkedList;
import java.util.Queue;

import com.BST.Node;

public class LevelOrderTraversal {
	Node root;
	
	protected void printLevelOrder(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		
		if(root == null)
			return;
		queue.add(root);
		while(!queue.isEmpty()){
			root=queue.poll();
			System.out.print(root.key);
			if(root.left != null)
				queue.add(root.left);
			if(root.right != null)
				queue.add(root.right);
		}
	}
	protected void printLevelOrderWithDelimeter(Node root){
		Queue<Node> q = new LinkedList<Node>();
		if (root == null) {
			return;
		}
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {
			root = q.poll();
			if (root != null){
				System.out.print(root.key+" ");
				if (root.left != null)
					q.offer(root.left);
				if (root.right != null)
					q.offer(root.right);
			}else{
				if (!q.isEmpty()){
					System.out.print("$");
					q.offer(null);
				}
			}
		}
	}
	public static void main(String[] args) {
		LevelOrderTraversal tree = new LevelOrderTraversal();
		
		tree.root = new Node(4); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(5); 
        tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(3);
        
        tree.printLevelOrder(tree.root);
        System.out.println();
        tree.printLevelOrderWithDelimeter(tree.root);
        System.out.println();
        tree.printLevelOrderTraversalLineByLine(tree.root);
	}
	private void printLevelOrderTraversalLineByLine(Node node) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		q.add(null);
		
		while (!q.isEmpty()){
			node = q.poll();
			if (node != null){
				System.out.print(node.key+" ");
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}else{
				if (!q.isEmpty()){
					System.out.print("$ ");
					q.add(null);
				}
				if (q.isEmpty())
					System.out.print("$");
			}
		}
		
	}
}
