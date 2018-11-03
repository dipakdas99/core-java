package com.BST;

import java.util.LinkedList;
import java.util.Queue;

import com.BST.Node;

public class LeftView {
	Node root;
	protected void printLeftView(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		
		if(root == null)
			return;
		queue.add(root);
		queue.add(null);
		System.out.print(root.key+" ");
		while(!queue.isEmpty()){
			Node curr =queue.poll();
			if (curr == null){
				if (!queue.isEmpty()){
					Node next =queue.poll();
					System.out.print(next.key+" ");
					queue.add(null);
					if (next.left != null)
						queue.add(next.left);
					if (next.right != null)
						queue.add(next.right);
				}
			}else{
				if (curr.left != null)
					queue.add(curr.left);
				if (curr.right != null)
					queue.add(curr.right);
				
			}
		}
	}
	protected void printRightView(Node root){
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()){
			int n = q.size();
			
			for ( int i=1; i<=n; i++ ){
				Node curr = q.poll();
				
				if ( i == n)
					System.out.print(curr.key+" ");
				
				if ( curr.left != null )
					q.add(curr.left);
				if ( curr.right != null )
					q.add(curr.right);
			}
		}
	}
	public static void main(String[] args) {
		LeftView tree = new LeftView();
		tree.root = new Node(10);
		tree.root.left = new Node(20);
		tree.root.right = new Node(30);
		tree.root.left.left = new Node(40);
		tree.root.left.right = new Node(60);
		tree.root.left.right.left = new Node(70);
		tree.root.right.left = new Node(90);
	    
	    tree.printLeftView(tree.root);
	    System.out.println();
	    tree.printRightView(tree.root);
	}

}
